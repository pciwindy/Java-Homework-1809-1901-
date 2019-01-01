package Library;

import dataBase.*;
import java.io.*;
import java.util.HashMap;
import java.util.Set;



public class BookLibrary implements ILibrary{
	private static BookLibrary instance = null;
	private HashMap<String, elementType> books = new HashMap<String, elementType>();
	private FileWriter writer;
	int number=0;
	public static BookLibrary getInstance() {
		if(instance == null) {
			synchronized(BookLibrary.class) {
				if(instance == null) {
					instance = new BookLibrary();
				}
			}
		}
		return instance;
	}
	
	public BookLibrary() {
		Book b=new Book();
		b.setBookId("ruarua");
		b.setBookName("rua");
		b.setNumber(10);
		books.put(b.getBookId(), b);
	}
	
	public void processBookString(String bookString) {//把读取的信息分割装到HashMap中
		String[] bookFile=bookString.split(",");
		Book bk = new Book();
		bk.setBookId(bookFile[0]);
		bk.setBookName(bookFile[1]);
		books.put(bk.getBookId(), bk);
		number++;
		
	}
	

	public void save() {
		Set<String> bkSet=books.keySet();
		try {
			writer = new FileWriter("book.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter bfw = new BufferedWriter(writer);
		for(String key:bkSet) {
			Book bk =(Book)books.get(key);
			String bkString = bk.getBookName()+","+bk.getBookId()+"\r\n";
			try {
				bfw.write(bkString);
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

	public void insert(elementType etp) {//添加图书
		Book bk = (Book)etp;
		books.put(bk.getBookId(), bk);
		number++;
		save();
	}

	public void delete(elementType etp) {//删除图书
		Book bk = (Book)etp;
		books.remove(bk.getBookId());
		number--;
		save();
	}
	
	public String search(String Search) {//搜书
		StringBuffer br = new StringBuffer();//key相当于bookid
		Set<String> bkSet = books.keySet();
		for(String key : bkSet) {
			Book book = (Book)books.get(key);
			String value = book.getBookName();
			if(value.equals(Search)) {//如果搜索的是书名
				//return borrows.get(key);
				br.append(key);
			}else if(key.equals(Search)) {//如果搜索的是id
				//return borrows.get(key);
				br.append(value);
			}else {
				//return null;
				br = null;
			}
		}
		return br.toString();
		
	}

	@Override
	public void update(elementType etp) {
		// TODO Auto-generated method stub
	}

	public HashMap<String, elementType> getAlletps() {
		return books;
	}

	public elementType getEtp(String id) {
		return books.get(id);
	}

}
