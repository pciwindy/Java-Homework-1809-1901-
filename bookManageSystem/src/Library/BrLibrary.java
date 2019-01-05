package Library;

import dataBase.*;

import java.io.*;
import java.util.*;

public class BrLibrary implements ILibrary {
	private static BrLibrary instance = null;
	private HashMap<String, elementType> borrows = new HashMap<String, elementType>();
	private FileWriter writer;
	private FileReader reader;
	BookLibrary bookLibrary = BookLibrary.getInstance();
	
	private BrLibrary() {
		getBrFromReader("borrow.txt");
	}

	public static BrLibrary getInstance() {
		if (instance == null) {
			synchronized (BrLibrary.class) {
				if (instance == null) {
					instance = new BrLibrary();
					return instance;
				}
			}
		}
		return instance;
	}
	
	private void getBrFromReader(String fileName) {//��Ҫ�и��������������
		try {
			reader = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(reader);
		String brString;
		try {
			while((brString=br.readLine()) != null){
				processBrString(brString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void processBrString(String brString) {
		if(brString!=null) {
			String[] brFileds=brString.split(",");
			Borrow borrow = new Borrow();
			borrow.setUsername(brFileds[0]);
			borrow.setBookId(brFileds[1]);
			borrows.put(borrow.getUsername(), borrow);
		}else {
			
		}
	}

	public void save() {// �������
		Set<String> brSet = borrows.keySet();
		try {
			writer = new FileWriter("borrow.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter bfw = new BufferedWriter(writer);
		for (String key : brSet) {
			Borrow br = (Borrow) borrows.get(key);
			String brString = br.getUsername() + "," + br.getBookId() + "\r\n";
			byte[] bytes = null;
			try {
				bytes = brString.getBytes("GBK");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			try {
				bfw.write(new String(bytes));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (bfw != null) {
			try {
				bfw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean update(elementType etp) {
		return false;
	}

	public HashMap<String, elementType> getAlletps() {
		return borrows;
	}

	public elementType getEtp(String search) {// ����.�����Ǹ�id���鱻�ĸ��˽�����Ǹ��˽���ʲô��,,Ӧ��ֻ�й���Ա�ܵ����������
		// ����
		// userName�൱��key,bookId�൱��value;
		StringBuffer b = new StringBuffer();
		Set<String> mykey = borrows.keySet();
		for (String key : mykey) {
			Borrow borrow = (Borrow) borrows.get(key);
			String value = borrow.getBookId();
			if (key.equals(search)) {
				b.append(key);
			} else if (value.equals(search)) {
				b.append(key);
			} else {
				b = null;
			}
		}
		return borrows.get(b.toString());

	}
	
	public boolean insert(elementType etp) {
		return false;
		
	}

	public boolean inserts(String name, String id) {//���飬��Ӧborrow
		Borrow br = (Borrow)borrows.get(name);
		Book book =  (Book)bookLibrary.getEtp(id);
		if(book != null&&br==null&&book.getNumber()>0) {//֮ǰû�нӹ���������������Ŀ������
			Borrow bw = new Borrow();
			bw.setUsername(name);
			bw.setBookId(id);
			borrows.put(bw.getUsername(), bw);
			int a = book.getNumber();
			book.setNumber(--a);
			BookLibrary bl = BookLibrary.getInstance();
			bl.save();
			save();
			return true;
		}else if(book != null && br != null&&book.getNumber()>0) {//���н����û��
			String bk = book.getBookId();
			br.setBookId(bk+ "," +id);
			int a = book.getNumber();
			book.setNumber(--a);
			BookLibrary bl = BookLibrary.getInstance();
			bl.save();
			save();
			return true;
		}else {
			save();
			return false;
		}
	}

	public boolean delete(elementType etp) {
		return false;
	}

	public boolean delete(String bookId, String userName) {// ���飬��Ӧrepay()
		Borrow br = (Borrow) borrows.get(userName);
		Book book = (Book) bookLibrary.getEtp(bookId);
		if (book!= null&&br!=null) {
			int nu = book.getNumber();
			book.setNumber(++nu);
			BookLibrary bl = BookLibrary.getInstance();
			bl.save();
			String[] brarray = br.getBookId().split(",");
			borrows.remove(userName);
			getBrFromReader("borrow.txt");
			StringBuffer brbf = new StringBuffer();
			if (brarray.length == 1) {
				borrows.remove(userName);
				save();
			} else {
				for (int i = 0; i < brarray.length; i++) {
					if (!(brarray[i].equals(bookId)) && i != brarray.length - 1) {
						brbf.append(brarray[i] + ",");
						break;
					} else if (!(brarray[i].equals(bookId)) && i == brarray.length - 1) {
						brbf.append(brarray[i]);
						break;
					}
				}
				BrLibrary brlibrary = BrLibrary.getInstance();
				Borrow borrow = new Borrow();
				borrow.setUsername(userName);
				borrow.setBookId(brbf.toString());
				brlibrary.insert(borrow);
				save();
			}
			save();
			return true;
		} else {
			return false;
		}
	}

	public elementType getBrer(String userName) {
		return borrows.get(userName);
	}
}
