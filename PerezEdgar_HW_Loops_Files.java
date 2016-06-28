import java.util.Scanner;       //Scanner for file input.
import java.io.File;            //File for Scanner class.
import java.io.IOException;     //IOExcaption for File class.
import javax.swing.JFrame;      //JFrame for JOptionPane class.
import javax.swing.JOptionPane; //JoptionPane for GUI.
import java.lang.StringBuffer;  //StringBuffer to append String data.

/**
 * @author Edgar Perez
 * Version 1.2
 * Examines data from the file "courseData.txt" and outputs an informative table in JOptionPane.
 */
public class PerezEdgar_HW_Loops_Files {

    public static void main(String[] args) throws IOException{
        String file = "courseData.txt"; //File name of dataset.
        Scanner input = null;           //Constructs new Scanner 'input' as null.
        JFrame frame = new JFrame("JOptionPane showMessageDialog"); 
        //Constructs new JFrame 'frame'.
        StringBuffer collect = new StringBuffer();                  
        //Constructs new StringBuffer 'collect'.                
        try{
            input = new Scanner(new File(file)); 
            //Constructs Scanner 'input' that produces values from 'file'.
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(frame,"There is something wrong with /"
        +file,"File Error",JOptionPane.ERROR_MESSAGE); //Error Message for an I/O Exception.
        }
        
        double programsWeight = input.nextDouble(); 
        //First double from file set as the program grades' weight.
        double midtermsWeight = input.nextDouble(); 
        //Second double from file set as the midterm grades' weight.
        double finalsWeight = input.nextDouble();   
        //Third double from file set as the final grades' weight.
        
        //testStatistics(input, programsWeight, midtermsWeight, finalsWeight);
        
        for(int i = 0; i < 3; i++){ //Determines the following values for the next three classes.
            collect.append(courseAverage(input, programsWeight, midtermsWeight, finalsWeight)); 
            //Appends the returned Strings from courseAverage()
        }
        JOptionPane.showMessageDialog(frame,collect,"Grade Report",JOptionPane.INFORMATION_MESSAGE);                                                                                                       //Information message/ table for the class data.
    }

    public static String courseAverage(Scanner input, double programsWeight, 
            double midtermsWeight, double finalsWeight) throws IOException{ 
    	//Returns a String of the course data in its entirety.
        int courseNumber = input.nextInt(); 
        //Following integer set as the course number.

        String first = "Grade Data For Class " + courseNumber+"\n\n"; 
        //String 'first' designated for course number;
        String second = "   ID     Programs   Midterm  Final  Weighted Average  Programs Grade\n";  
        //String 'second' designated for headings.
        String third = "-------  ---------------  ------------  ------  --------------------------  "
        		+ "------------------------\n";  //String 'third' designated for aesthetics.

        int studentNumber, programsGrade, midtermsGrade, finalsGrade, studentCount = 0; 
        //Various integers set for student's number and their respective grades.
        double weightedAverage, average = 0;      
        //Double 'weightedAverage' for each student, 'average' for the whole class.
        String coursePassFail = "";  
        //Empty String 'classPassFail' designated for the result of their 'programsGrade'.
        StringBuffer grades = new StringBuffer(); //Constructs new StringBuffer 'grades'.
        
        while (courseNumber >= 100){    
        	//Computes the following procedures if the 'courseNumber' is greater than 100.
            studentNumber = input.nextInt();     //Following integer set as 'studentNumber'.
            if (studentNumber > 1000){ 
            	//Computes the following procedures if the 'studentNumber' is greater than 1000.
                programsGrade = input.nextInt(); //Following integer set as 'programsGrade'
                midtermsGrade = input.nextInt(); //Following integer set as 'midetermsGrade'.
                finalsGrade = input.nextInt();   //Following integer set as 'finalsGrade'.                  
                weightedAverage = (programsWeight*programsGrade)+(midtermsWeight*midtermsGrade)
                		+(finalsWeight*finalsGrade); //Computes the weighted average for each student.
                average += weightedAverage; //Collects the 'weightedAverage' for the entire course.
                studentCount++;             //Increments for each student in a course.
                
                if (programsGrade >= 70){  
                    coursePassFail = ("PASS"); 
                    //Sets 'classPassFail' as "PASS" grade if 'programsGrade' is greater than/ equal to 70.
                }
                else{
                    coursePassFail = "FAIL";  
                    //Sets 'classPassFail' as "FAIL" grade for 'programsGrade' is less than 70.
                }
            
                String student = String.format("%d %11d %16d %10d %20.2f %27s\n", studentNumber, 
                		programsGrade, midtermsGrade, finalsGrade, weightedAverage, coursePassFail); 
                //Sets 'student' as a String with their [student's] respective data.
                grades.append(student); //Appends the Strings of each 'student'.
            }
            else{
                courseNumber = 0; //Sets the condition in the while loop as false.
            }
        }
        
        double classAverage = average / studentCount; 
        //Double 'classAverage' set to the calculation of the course's total average. 
        String total = String.format("Class average is: %.2f\n\n\n", classAverage); 
        //String which describes the 'classAverage'.
        String omega = first+second+third+grades+total; //String 'omega' set to a course's entire data.
        
        return omega;
    }
    
    public static void testStatistics(Scanner input, double programsWeight, 
            double midtermsWeight, double finalsWeight) throws IOException{
        StringBuffer test = new StringBuffer(); //Constructs new StringBuffer 'test'.
        for(int i = 0; i < 3; i++){ //Determines the following values for the next three classes.
            test.append(courseAverage(input, programsWeight, midtermsWeight, finalsWeight)); 
            //Appends the returned Strings from classAverage()
        }
        System.out.println(test);
    }
    
}
