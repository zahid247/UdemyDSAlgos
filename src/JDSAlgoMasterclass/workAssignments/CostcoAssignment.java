package JDSAlgoMasterclass.workAssignments;

import java.util.*;

public class CostcoAssignment {

    public static void main(String[] args) {

//        int[] arr = new int[] {4, 5, -2, 3, 1, 2, 6, 6};
//        System.out.println(ArrayChallenge(arr));
//        System.out.println(RecursionChallenge(8));

        System.out.println(findRepetitive("ayla"));
    }

    public static int ArrayChallenge(int[] arr) {

        int sum = 0;
        int length = arr.length;
        int numRequested = 4;

        if (length < numRequested) return -1;

        //first sort the array
        for (int i = 0; i < numRequested; i++) {
            System.out.println("i = " + i + " && arr[i] = " + arr[i]);
            for (int j = i + 1; j < length; j++) {

                System.out.println("j = " + j + " && arr[j] = " + arr[j]);

                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }

        //once the array has been sorted, find the sum of the first four elements
        for (int i = 0; i < 4; i++) {
            sum += arr[i];
        }

        return sum;

    }

    public static int RecursionChallenge(int num) {
        if (num == 1) return num;
        return num * RecursionChallenge(num - 1);
    }

    public static Map<Character, Integer> findRepetitive(String s) {
        Map<Character, Integer> letters = new HashMap<>();
        Map<Character, Integer> result = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (!letters.containsKey(c)) letters.put(c, 1);
            else {
                letters.put(c, letters.getOrDefault(c, 0) + 1);
                if (letters.get(c) > 1) result.put(c, letters.get(c));
            }
        }
        return result;
    }
}



//    import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.io.IOException;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//    class Main {
//        public static void main(String[] args) {
//            // Set the User-Agent to mimic a browser (optional, depends on API)
//            System.setProperty("http.agent", "Chrome");
//
//            try {
//                // Replace "URL" with the actual URL you are requesting
//                URL url = new URL("https://example.com/api"); // Change to the actual URL
//
//                // Open connection and cast to HttpURLConnection
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestMethod("GET");
//                connection.setRequestProperty("Accept", "application/json");
//
//                // Check the response code
//                int responseCode = connection.getResponseCode();
//                if (responseCode == HttpURLConnection.HTTP_OK) { // Success
//
//                    // Read the input stream (response from the server)
//                    InputStream inputStream = connection.getInputStream();
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//                    StringBuilder response = new StringBuilder();
//                    String line;
//
//                    // Read the response line by line
//                    while ((line = reader.readLine()) != null) {
//                        response.append(line);
//                    }
//
//                    // Close the reader and input stream
//                    reader.close();
//                    inputStream.close();
//
//                    // Convert the response to a JSON object
//                    JSONObject jsonResponse = new JSONObject(response.toString());
//
//                    // Extract the "hobbies" array from the JSON
//                    JSONArray hobbies = jsonResponse.getJSONArray("hobbies");
//
//                    // Build a string to output the hobbies in the desired format
//                    StringBuilder hobbiesOutput = new StringBuilder();
//
//                    for (int i = 0; i < hobbies.length(); i++) {
//                        hobbiesOutput.append(hobbies.getString(i));
//                        if (i < hobbies.length() - 1) {
//                            hobbiesOutput.append(", ");
//                        }
//                    }
//
//                    // Print the hobbies to the console
//                    System.out.println(hobbiesOutput.toString());
//
//                } else {
//                    System.out.println("GET request failed. Response Code: " + responseCode);
//                }
//            } catch (MalformedURLException malEx) {
//                System.out.println("MalformedURLException: " + malEx.getMessage());
//            } catch (IOException ioEx) {
//                System.out.println("IOException: " + ioEx.getMessage());
//            } catch (Exception ex) {
//                System.out.println("Exception: " + ex.getMessage());
//            }
//        }
//    }
//
//import java.util.*;
//import java.io.*;
//import java.net.*;
//
//    class Main {
//        public static void main(String[] args) {
//            // Set the User-Agent to mimic a browser (optional, depends on API)
//            System.setProperty("http.agent", "Chrome");
//
//            try {
//                // Replace "URL" with the actual URL you are requesting
//                URL url = new URL("https://example.com/api"); // Change to the actual URL
//
//                // Open connection and cast to HttpURLConnection
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestMethod("GET");
//                connection.setRequestProperty("Accept", "application/json");
//
//                // Check the response code
//                int responseCode = connection.getResponseCode();
//                if (responseCode == HttpURLConnection.HTTP_OK) { // Success
//
//                    // Read the input stream (response from the server)
//                    InputStream inputStream = connection.getInputStream();
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//                    StringBuilder response = new StringBuilder();
//                    String line;
//
//                    // Read the response line by line
//                    while ((line = reader.readLine()) != null) {
//                        response.append(line);
//                    }
//
//                    // Close the reader and input stream
//                    reader.close();
//                    inputStream.close();
//
//                    // Convert the response to a string
//                    String jsonResponse = response.toString();
//
//                    // Manually extract the "hobbies" array from the JSON response
//                    List<String> hobbies = extractHobbies(jsonResponse);
//
//                    // Print the hobbies in the desired format
//                    System.out.println(String.join(", ", hobbies));
//
//                } else {
//                    System.out.println("GET request failed. Response Code: " + responseCode);
//                }
//            } catch (MalformedURLException malEx) {
//                System.out.println("MalformedURLException: " + malEx.getMessage());
//            } catch (IOException ioEx) {
//                System.out.println("IOException: " + ioEx.getMessage());
//            } catch (Exception ex) {
//                System.out.println("Exception: " + ex.getMessage());
//            }
//        }
//
//        // A method to manually extract the hobbies array from a JSON-like string
//        private static List<String> extractHobbies(String jsonResponse) {
//            List<String> hobbiesList = new ArrayList<>();
//
//            // Find the start of the hobbies array
//            String hobbiesKey = "\"hobbies\":";
//            int startIndex = jsonResponse.indexOf(hobbiesKey);
//
//            if (startIndex != -1) {
//                // Move index to the start of the array (right after "hobbies":[)
//                startIndex = jsonResponse.indexOf('[', startIndex) + 1;
//
//                // Find the end of the hobbies array (the closing bracket of the array)
//                int endIndex = jsonResponse.indexOf(']', startIndex);
//
//                if (endIndex != -1) {
//                    // Extract the string containing the array items
//                    String hobbiesArray = jsonResponse.substring(startIndex, endIndex);
//
//                    // Split the array by commas and remove quotes/spaces
//                    String[] hobbiesItems = hobbiesArray.split(",");
//                    for (String item : hobbiesItems) {
//                        // Remove any leading/trailing whitespace and double quotes
//                        hobbiesList.add(item.trim().replace("\"", ""));
//                    }
//                }
//            }
//            return hobbiesList;
//        }
//    }
