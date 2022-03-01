import java.util.Arrays;

public class Block {
        public int validBit;
        public int tagBit;
        //block size 16 bytes
        public int[] blockArray=new int[16];

        public Block(){
            validBit=0;
            tagBit=-1;
            Arrays.fill(blockArray, 0);
        }

        public void Show(){
            System.out.println(validBit);
            System.out.println(tagBit);
            for (int i=0;i<blockArray.length;i++){
                System.out.println(blockArray[i]);
            }
        }
}

/*

 */





