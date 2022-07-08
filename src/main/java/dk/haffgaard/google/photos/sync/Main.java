package dk.haffgaard.google.photos.sync;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.photos.library.v1.PhotosLibrarySettings;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        try {
            CredentialsProvider credentialsProvider =
                    FixedCredentialsProvider.create(
                            GoogleCredentials.fromStream(new FileInputStream("credentials.json")));

            PhotosLibrarySettings settings =
                    PhotosLibrarySettings.newBuilder()
                            .setCredentialsProvider(credentialsProvider)
                            .build();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
