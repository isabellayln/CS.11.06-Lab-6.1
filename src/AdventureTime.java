import java.io.*;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int challengeOneAnswer = challengeOne("testInputOneTwo.txt");
        System.out.println(challengeOneAnswer);
        int challengeTwoAnswer = challengeTwo("testInputOneTwo.txt");
        System.out.println(challengeTwoAnswer);
        int challengeThreeAnswer = challengeThree("testInputThreeFour.txt");
        System.out.println(challengeThreeAnswer);
        int challengeFourAnswer = challengeFour("testInputThreeFour.txt");
        System.out.println(challengeFourAnswer);
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int[] depths = readFile(fileName);
        int count = 0;
        for(int i =1; i< depths.length; i++){
            if(depths[i]>depths[i-1]) {
                count++;
            }
        }
        return count;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] depths = readFile(fileName);
        int count = 0;
        for (int i=0;i<depths.length-3;i++){
            int firstSum = depths[i]+depths[i+1]+depths[i+2];
            int secondSum = depths[i+1]+depths[i+2]+depths[i+3];
            if(secondSum>firstSum){
                count++;
            }
        }
        return count;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        String[] depths = readFile2(fileName);
        int horizontal = 0;
        int vertical = 0;
        for(int i=0; i<depths.length; i++) {
            String[] position = depths[i].split(" ");
            if (position[0].equals("forward")) {
                horizontal += parseInt(position[1]);
            } else if (position[0].equals("up")) {
                vertical += parseInt(position[1]);
            } else {
                vertical -= parseInt(position[1]);
            }
        }
        return horizontal*vertical;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        String[] depths = readFile2(filename);
        int horizontal = 0;
        int depth = 0;
        int aim = 0;
        for(int i=0; i<depths.length; i++) {
            String[] position = depths[i].split(" ");
            if (position[0].equals("up")) {
                aim -= parseInt(position[1]);
            } else if (position[0].equals("down")){
                aim += parseInt(position[1]);
            } else {
                horizontal += parseInt(position[1]);
                depth += aim*parseInt(position[1]);

            }
        }
        return horizontal*depth;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    private static String[] readFile2(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }


    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}