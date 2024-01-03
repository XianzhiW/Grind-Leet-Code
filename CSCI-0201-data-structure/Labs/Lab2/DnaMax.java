// Name: Xianzhi Wang 
// CSCI 201 Lab 2

public class DnaMax {

    // find strand with most occurrences of substring nuc
    public String maxStrand(String[] strands, String nuc) {
        DnaMax myDNA = new DnaMax();
        String myMaxStrand = strands[0];
        for (int i = 0; i< strands.length; i++){
            if (myDNA.countOccurrences(myMaxStrand, nuc)< myDNA.countOccurrences(strands[i], nuc)){
                    myMaxStrand = strands[i];
                }

            else if ( (myDNA.countOccurrences(myMaxStrand, nuc) == myDNA.countOccurrences(strands[i], nuc)) && 
            (myMaxStrand.length() < strands[i].length()) ){
                    myMaxStrand = strands[i];
                }
            }
        
        if (myDNA.countOccurrences(myMaxStrand, nuc) <= 0){
            myMaxStrand = "";
        }

        return myMaxStrand;
    }

    public int countOccurrences(String strand, String nuc){
        int count = 0;
        for (int i = 0; i < strand.length(); i++){

            if (strand.substring(i, i+1).equals(nuc)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        DnaMax dna = new DnaMax();
        String[] strands1 = {"agt", "aagt", "taattt", "ccatg" };
        String[] strands2 = {"agt", "aagt", "taattt", "ccatc" };
        String[] strands3 = {"g", "gg", "ggg", "gggg" };
        System.out.println(dna.maxStrand(strands1, "a"));
        System.out.println(dna.maxStrand(strands2, "g"));
        System.out.println(dna.maxStrand(strands3, "c"));
    }
    
}
