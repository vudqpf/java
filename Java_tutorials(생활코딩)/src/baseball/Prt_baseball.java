package baseball;

public class Prt_baseball {
	public static void main(String[] args) {
		int[] com = new int[3];
		int[] gamer = new int[3];
		
		Com cm = new Com();
		User user = new User();
		Game game = new Game();
		
		cm.initNumberList();
		
		System.out.println(" ==== 숫자 야구 게임 ==== ");
	}
	
	
	
	abstract class Play{
		protected int[] num = new int[3];
		
		abstract void selectnumber();
		
		public int[] get_Number() {
			return num;
		}
	}

}
