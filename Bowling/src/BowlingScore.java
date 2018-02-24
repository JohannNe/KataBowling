import java.util.ArrayList;
import java.util.Arrays;

public class BowlingScore {
	
	public static void main (String[]args){
		
		ArrayList<Integer> bowlingSequence = new ArrayList();
		//bowlingSequence.addAll(Arrays.asList(10,10,10,10,10,10,10,10,10,10,10,10));
		//bowlingSequence.addAll(Arrays.asList(9,0,9,0,9,0,9,0,9,0,9,0,9,0,9,0,9,0,9,0));
		//bowlingSequence.addAll(Arrays.asList(5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5));
		//bowlingSequence.addAll(Arrays.asList(5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1));
		bowlingSequence.addAll(Arrays.asList(5,5,5,5,5,0,5,5,5,5,5,5,5,5,5,5,5,5,5,1));
		int iScore = giveScore(bowlingSequence);
		System.out.println(iScore);
	}
	
	public static int giveScore(ArrayList<Integer> sequence){
		int iScore = 0;
		int iFrameIndex = 0;
		int iPins=0;
		int iPinsFirstTry=0;
		boolean bSecondTry = false;
		boolean bStrike = false;
		
		for(int i=0;i<sequence.size();i++){
			
			iPins = sequence.get(i);
			iScore += iPins;
			
			if(iFrameIndex<9){ //No extra points for strikes or spares in the last frame
				if(iPins==10){ //Player hits strike
					iScore+= sequence.get(i+1) + sequence.get(i+2);
					bStrike = true;
				}
				else if(bSecondTry){
					if(iPins+iPinsFirstTry == 10){ //Player hits spare
						iScore+= sequence.get(i+1);
					}
				}
				else{
					iPinsFirstTry = iPins;
				}
				
			}	
			
			if(bStrike || bSecondTry){
				iFrameIndex +=1;
				bStrike = false;
				bSecondTry = false;
			}
			else{
				bSecondTry = true;
			}
			
			
		}
		
		
		
		return iScore;
	}
}
