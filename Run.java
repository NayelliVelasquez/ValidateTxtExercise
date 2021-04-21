/**
 * Main class.
 */
public class Run {
    public static void main(String args[]){
        ReadFileTxt rft=new ReadFileTxt("words.txt");
        rft.obtainLongestCompound();
    }
}
