import java.util.Random;

public class Cache {

    //main memory with 16 bit address i.e. 2^16=65536
    int[] mainMemory = new int[65536];
    int cacheHit=0;
    int cacheMiss=0;
    //cache memory has 64 blocks
    Block[] cacheMemory=new Block[64];
    int address=0;
    String tag="";
    String block="";
    String offset="";
    int intBlock=0;
    int count=0;
    int blockStart=0;

    //to initiate random
    Random rand=new Random();


    public Cache(){
        //Populating main memory with random statements
        for(int i=0;i<512;i++){
            mainMemory[i]=rand.nextInt(127)+1;
        }
        for(int i=0;i<64;i++){
            cacheMemory[i]=new Block();
        }
    }

    public void CacheController(int num){

        //convert it into 16 bit binary using Integer.toBinaryString(number)
        String binAddress=Integer.toBinaryString(num);

        // A while loop for 16 bits address
        while(binAddress.length()!=16){
            binAddress="0"+binAddress;
        }

        //splitting the binary address
        //split in 3 fields offset (4 bits), (6 bits to address 64 blocks), remaining 6 bits for tag
        tag=binAddress.substring(0,6);
        block=binAddress.substring(6,12);
        offset=binAddress.substring(12);

        //search in that cache memory block
        //convert the string binary to an integer block number
        intBlock=Integer.parseInt(block,2);
        System.out.println(intBlock);
        if(cacheMemory[intBlock].validBit==0){
            cacheMiss++;
            System.out.println("Executing from main memory and copying the block in cache");
            //FOR COPYING FROM MAIN MEMORY, we gotta copy a whole block i.e, 16 memory addresses

            count=num/16;
            if(count==0)
                blockStart=num;
            else
                blockStart=num-count;

            for(int i=0, k=blockStart; i<16; i++,k++){
                //main memory to cache
                cacheMemory[intBlock].blockArray[i]=mainMemory[k];
            }
            cacheMemory[intBlock].validBit=1;
            cacheMemory[intBlock].tagBit=Integer.parseInt(tag);
        }
        else
        {
            if(cacheMemory[intBlock].tagBit==Integer.parseInt(tag))
                cacheHit++;
            System.out.println("Executing from cache");
        }

    }


    public void generateRandomAddress(){
        //generate addresses from 0-511 (total 512)
        for(int i=0;i<512;i++){
            address=rand.nextInt(510)+1;
            CacheController(address);
        }
        System.out.println("The total number of cache hits are: "+cacheHit);
        System.out.println("The total number of cache miss are: "+cacheMiss);

    }

    public void getResult(){
        for (int i=0;i<500;i++){
            System.out.println(mainMemory[i]);
        }
    }


}



