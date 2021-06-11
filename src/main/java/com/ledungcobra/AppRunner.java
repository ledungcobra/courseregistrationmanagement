package com.ledungcobra;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.scenes.ConfigDatabaseScreen;
import com.ledungcobra.utils.Navigator;
import lombok.val;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.ledungcobra.utils.Constants.*;

public class AppRunner
{


    public static void main(String[] args) throws InterruptedException
    {

        Properties properties = new Properties();

        try (InputStream inputStream = new FileInputStream(CONFIG_FILE_NAME))
        {
            properties.load(inputStream);
        } catch (IOException e)
        {
            try
            {
                if (new File(CONFIG_FILE_NAME).createNewFile())
                {
                    System.out.println("Created new config file");
                }
            } catch (IOException ioException)
            {
                ioException.printStackTrace();
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        // Load app context
        val navigator = new Navigator<ConfigDatabaseScreen>();
        Map<String, Object> data = new HashMap<>();

        if (properties.isEmpty())
        {
            data.put(CONNECTION_STRING, DEFAULT_CONNECTION_STRING);
            data.put(USER_NAME, DEFAULT_USER_NAME);
            data.put(PASSWORD, DEFAULT_PASSWORD);
        } else
        {
            data.put(CONNECTION_STRING, properties.get(CONNECTION_STRING));
            data.put(USER_NAME, properties.get(USER_NAME));
            data.put(PASSWORD, properties.get(PASSWORD));
        }

        navigator.navigate(data);
        Thread.currentThread().join();

        // Clean up resources
        AppContext.closeSession();
        AppContext.executorService.shutdown();
    }
}
