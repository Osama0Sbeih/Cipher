



import java.io.*;

public class StringEncryption {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        char arr[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        String word = reader.readLine();
        String newword = "";
        int index = 0;
        int random = (int) (Math.random() * 51);
        System.out.println(random);
        for (int i = 0;i<word.length();i++){
            for (int j = 0;j<arr.length;j++){
                if (arr[j] == word.charAt(i)){
                    index = j;
                    break;
                }

            }
            if ((index+random) > 25){
                newword+= arr[Math.abs(random+index-26)];
            }
            else
                newword+=arr[index +random];


        }

        writer.println(newword);
        writer.flush();
    }
}
