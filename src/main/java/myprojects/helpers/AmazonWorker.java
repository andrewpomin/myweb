package myprojects.helpers;

import myprojects.secure.SecureData;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsRequest;
import software.amazon.awssdk.services.s3.model.S3Object;

import java.util.List;

public class AmazonWorker {

    public S3Client getConnection() {
        AwsCredentials credentials = SecureData.getAwsCredentials();
        Region region = Region.EU_CENTRAL_1;
        return S3Client.builder().credentialsProvider(StaticCredentialsProvider.create(credentials)).region(region).build();
    }

    public List<S3Object> getObjectsList() {
        S3Client client = getConnection();
        String bucket = "myweb-cloud-bucket";
        return client.listObjects(ListObjectsRequest.builder().bucket(bucket).build()).contents();
    }

    public int getListSize(List<S3Object> list) {
        return list.size();
    }

    public String getObjectKey(S3Object object) {
        return object.key();
    }

    public String getURL(String key) {
        String bucket = "myweb-cloud-bucket";
        S3Client client = getConnection();
        return String.valueOf(client.utilities().getUrl(GetUrlRequest.builder().bucket(bucket).key(key).build()));
    }
}
