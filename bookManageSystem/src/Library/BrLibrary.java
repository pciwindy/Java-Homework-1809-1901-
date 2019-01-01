package Library;

import dataBase.*;

import java.io.*;
import java.util.*;


public class BrLibrary implements ILibrary{
	private static BrLibrary instance=null;
	private HashMap<String, elementType> borrows=new HashMap<String, elementType>();
	private FileWriter writer;
	public static BrLibrary getInstance() {
		if(instance == null) {
			synchronized(BrLibrary.class) {
				if(instance == null) {
					instance = new  BrLibrary();
					return instance;
				}
			}
		}
		return instance;
	}
	
	public void save() {//保存操作
		Set<String> brSet=borrows.keySet();
		try {
			writer = new FileWriter("borrow.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter bfw = new BufferedWriter(writer);
		for(String key:brSet) {
			Borrow br =(Borrow)borrows.get(key);
			String brString = br.getUsername()+","+br.getBookId()+"\r\n";
			try {
				bfw.write(brString);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(bfw != null) {
			try {
				bfw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*public void insert(elementType etp, String bookId) {
		// TODO Auto-generated method stub
		//DBUtil dbUtil = DBUtil.getInstance();
		//dbUtil.update();
		//UserLibrary us = UserLibrary.getInstance();
		//us.insert((User)etp);
		Borrow br = (Borrow)etp;
	    borrows.put(br.getUsername(), br);
	}*/
	
	/*public void delete(elementType etp, String bookId) {
		// TODO Auto-generated method stub
		Borrow br = (Borrow)etp;
	    br.setBookId(bookId);
	}*/
	
	/*public String search(String Search) {
		Set<String> brSet = borrows.keySet();
		StringBuffer brbf = new StringBuffer();
		for(String brusername : brSet) {
			Borrow brs = (Borrow) borrows.get(brusername);
			brs.getBookId();
			if(Search.equals(brs.getBookId())) {
				String brString = brs.getUsername() + "," + brs.getBookId();
				brbf.append(brString);
			}
		}
		return brbf.toString();
	}*/
	
	@Override
	public void update(elementType etp) {
		// TODO Auto-generated method stub
		
	}
	
	public HashMap<String, elementType> getAlletps() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public elementType getEtp(String search) {//搜书.看看那个id的书被哪个人借或者那个人借了什么书,,应该只有管理员能调用这个功能
		// TODO Auto-generated method stub
		//搜索
		//userName相当于key,bookId相当于value;
		StringBuffer b = new StringBuffer();
		Set<String> mykey = borrows.keySet();
			for(String key : mykey) {
				Borrow borrow = (Borrow)borrows.get(key);
				String value = borrow.getBookId();
				if(key.equals(search)) {
					//return borrows.get(key);
					b.append(key);
				}else if(value.equals(search)) {
					//return borrows.get(key);
					b.append(key);
				}else {
					//return null;
					b = null;
				}
			}
		return borrows.get(b.toString());
		
	}
	
	public void insert(elementType etp) {//借书,对应borrow()
		// TODO Auto-generated method stub
		Borrow borrow = (Borrow)etp;
		borrows.put(borrow.getUsername(), borrow);
		System.out.println("yes!");
		save();
	}
	
	@Override
	public void delete(elementType etp) {
		// TODO Auto-generated method stub
		//Borrow borrow = (Borrow)etp;
		//borrows.remove(borrow.getUsername());
	}
	public void delete(String bookId, String userName) {//还书，对应repay()
		/*Set<String> brkey = borrows.keySet();
		for(String key : brkey) {
			if()
		}*/
		Borrow br = (Borrow)borrows.get(userName);
		borrows.remove(userName);
		String[] brarray = br.getBookId().split(",");
		StringBuffer brbf = new StringBuffer();
		for(int i = 0; i < brarray.length; i ++) {
			if(!(brarray[i].equals(bookId)) && i != brarray.length-1) {
				brbf.append(brarray[i] + ",");
			}else if(!(brarray[i].equals(bookId)) && i == brarray.length-1) {
				brbf.append(brarray[i]);
			}
		}
		//String[] b = brbf.toString().split(",");
		//borrows.put(userName, borrow);
		BrLibrary brlibrary=BrLibrary.getInstance();
		Borrow borrow =new Borrow();
		borrow.setUsername(userName);
		borrow.setBookId(brbf.toString());
		brlibrary.insert(borrow);
		save();
	}

}
