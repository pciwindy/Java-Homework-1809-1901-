package P162_6_3;

class Player {
	public void play(int index)throws NoThisSoundException{
		if(index==11) {//测试无参调用
			throw new NoThisSoundException();//调用无参
		}
		else if(index>11) {//测试有参调用
			throw new NoThisSoundException("这个歌曲它不存在！");//将错误信息抛出
		}
		else {
			System.out.println("Playing.......");
		}
	}
}
