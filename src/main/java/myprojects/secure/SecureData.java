package myprojects.secure;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;

public class SecureData {
    public static AwsCredentials getAwsCredentials() {return AwsBasicCredentials.create("******", "******");}
}
