package myprojects.secure;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;

public class SecureData {
    public static AwsCredentials getAwsCredentials() {return AwsBasicCredentials.create("AKIAYSTKG6USMEV6PL5Z", "GaA/XfbM+9WY8FjAI6iEHYZjv9krQji+tp7kFloZ");}
}
