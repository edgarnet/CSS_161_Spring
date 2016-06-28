import java.util.Scanner;

public class PerezEdgar_HW_Loops {
    
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        boolean complete = false;
        
        while(!complete){ //Continues given user enters invalid sequences.
            System.out.println("Enter a genetic sequence:");
            String parentOne = keyboard.nextLine(); //First parent's sequence.
            System.out.println("Enter another genetic sequence:");
            String parentTwo = keyboard.nextLine(); //Second parent's sequence.
            if(sequenceCheck(parentOne) && sequenceCheck(parentTwo)){  //If both sequences are valid.
                System.out.println("\nSequence 1: " + parentOne);  
                c_Count(parentOne);  //First parent's C-Count.
                cg_Ratio(parentOne); //First parent's CG-Ratio.
                complement(parentOne); //First parent's complement. 
                System.out.println("Sequence 2: " + parentTwo);
                c_Count(parentTwo);  //Second parent's C-Count.
                cg_Ratio(parentTwo); //Second parent's CG-Ratio.
                complement(parentTwo); //Second parent's complement.
                alignment(parentOne,parentTwo); //Parent's respective alignment. 
                complete = true; //Loop ends when methods have completed.
            }
            else{
                System.out.println("Enter a valid sequence!"); //Error message.
            }
        }
    }
    
    public static boolean sequenceCheck(String dna){ //Returns true if a sequence includes the correct nucleotide types.
        boolean found = false;
        int count = 0;
        
        for(int i = 0; i < dna.length(); i++){
            if('A' != dna.charAt(i) && 'C' != dna.charAt(i) && 'T' != dna.charAt(i) && 'G' != dna.charAt(i)){
                count++; //If an invalid character is found, count increments.
            }
        }
        if(count > 0){
            found = false; //If count has incremented, the sequence becomes invalid.
        }
        else{
            found = true;
        }
        
        return found;
    }
    
    public static void c_Count(String dna){ //Outputs the number of 'C' nucleotides found in a sequence. 
        int count = 0;
        
        for(int i = 0; i < dna.length(); i++){
            if(dna.charAt(i) == 'C'){
                count++; //Increments for every 'C' nucleotide found.
            }
        }
        
        System.out.println("\tC-count: "+count);
    }
    
    public static int cg_Count(String dna){ //Returns the number of 'C' and 'G' nucleotides found in a sequence.
        int countC = 0;
        int countG = 0;
        
        for(int i = 0; i < dna.length(); i++){
            if(dna.charAt(i) == 'C'){
                countC++; //Increments for every 'C' nucleotide found.
            }
        }
        for(int i = 0; i < dna.length(); i++){
            if(dna.charAt(i) == 'G'){
                countG++; //Increments for every 'G' nucleotide found.
            }
        }
        
        int total = countC + countG; //Adds the number of 'C' and 'G' nucleotides.
        return total;
    }
    
    public static void cg_Ratio(String dna){ //Outputs the ratio of 'C' and 'G' nucleotides to the entire sequence. 
        int sequenceLength = dna.length();
        int total = cg_Count(dna);
        double cgRatio = total/(double)sequenceLength; //Calculates the ratio.
        
        System.out.printf("\tCG-ratio: %.3f\n",cgRatio); 
    }
    
    public static void complement(String dna){ //Outputs a given sequence's complement.
        String newDna = ""; //New sequence where conversions are stored.
        
        for(int i = 0; i < dna.length(); i++){
            if(dna.charAt(i) == 'A'){
                newDna+="T"; //'A' nucleotides convert to 'T' nucleotides. 
            }
            else if(dna.charAt(i) == 'T'){
                newDna+="A"; //'T' nucleotides convert to 'A' nucleotides.
            }
            else if(dna.charAt(i) == 'C'){
                newDna+="G"; //'C' nucleotides convert to 'G' nucleotides.
            }
            else if(dna.charAt(i) == 'G'){
                newDna+="C"; //'G' nucleotides convert to 'C' nucleotides.
            }
        }
        
        System.out.println("\tComplement: "+newDna+"\n");
    }
    
    public static int alignShift(String largeNuc, String shortNuc, int offset){ //Returns the scores for all possible alignments.
        int count = 0;
        
        String bigSub = largeNuc.substring(offset, offset+shortNuc.length()); //Shifts the larger sequence according to the offset by the shorter sequence.
        for(int i = 0; i < shortNuc.length(); i++){
            if(shortNuc.charAt(i) == bigSub.charAt(i)){
                count++; //Increments for all matches within the given substring. 
            }
        }
        
        return count;
    }
    
    public static void alignment(String aDna, String bDna){ //Outputs the best alignment and its respective score.
        int firstLength = aDna.length();
        int secondLength = bDna.length();
        String largeNuc ="";
        String shortNuc ="";
        int count = 0;
        int maxMatch = 0;
        int offset = 0;
        
        if(firstLength > secondLength){ /** Outer if/else statements determine the size of each sequence **/ 
            largeNuc = aDna;
            shortNuc = bDna;
            for(int i = 0; i < largeNuc.length() - shortNuc.length(); i++){ //Increments for each alignment.
                int matches = alignShift(largeNuc, shortNuc, i);
                if(maxMatch < matches){ //Determines the largest of each score.
                    maxMatch = matches;
                    offset = i; //Offset set to the highest score's increment.
                }
            }
            for(int i = 0; i < offset; i++){
                String r_B = " "; //Empty offset value.
                shortNuc = r_B.concat(shortNuc); //Empty offsets concatenate followed by the shorter sequence.
            }
            System.out.println("Best alignment score: "+maxMatch);
            System.out.printf("\t"+largeNuc+"\n\t"+shortNuc);
        }
        else if(firstLength == secondLength){
            for(int i = 0; i < firstLength; i++){ 
                if(aDna.charAt(i) == bDna.charAt(i)){
                    count++; //Increments for each match found.
                }
            }
            maxMatch = count;
            System.out.println("Best alignment score: "+maxMatch);
            System.out.printf("\t"+aDna+"\n\t"+bDna);
        }
        else{
            largeNuc = bDna;
            shortNuc = aDna;
            for(int i = 0; i < largeNuc.length() - shortNuc.length(); i++){ //Increments for each alignment.
                int matches = alignShift(largeNuc, shortNuc, i);
                if(maxMatch < matches){ //Determines the largest of each score.
                    maxMatch = matches;
                    offset = i; //Offset set to the highest score's increment.
                }
            }
            for(int i = 0; i < offset; i++){
                String r_B = " "; //Empty offset value.
                shortNuc = r_B.concat(shortNuc); //Empty offsets concatenate followed by the shorter sequence.
            }
            System.out.println("Best alignment score: "+maxMatch);
            System.out.printf("\t"+largeNuc+"\n\t"+shortNuc);
        }
    }
    
}