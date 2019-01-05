package Library;

import dataBase.*;
import java.io.*;
import java.util.HashMap;
import java.util.Set;

public class BookLibrary implements ILibrary {
	private static BookLibrary instance = null;
	private HashMap<String, elementType> books = new HashMap<String, elementType>();
	private FileWriter writer;
	private FileReader reader;

	public static BookLibrary getInstance() {
		if (instance == null) {
			synchronized (BookLibrary.class) {
				if (instance == null) {
					instance = new BookLibrary();
				}
			}
		}
		return instance;
	}

	public BookLibrary() {
		getBookFromReader("book.txt");
	}

	private void getBookFromReader(String fileName) {// 需要有个来调用这个方法
		try {
			reader = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(reader);
		String bookString;
		try {
			while ((bookString = br.readLine()) != null) {
				processBookString(bookString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void processBookString(String bookString) {// 把读取的信息分割装到HashMap中
		if (bookString != null) {
			String[] bookFile = bookString.split(",");
			Book bk = new Book();
			bk.setBookName(bookFile[0]);
			bk.setBookId(bookFile[1]);
			bk.setNumber(Integer.parseInt(bookFile[2]));
			books.put(bk.getBookId(), bk);
		}
		else {
			
		}
	}

	public void save() {
		Set<String> bkSet = books.keySet();
		try {
			writer = new FileWriter("book.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter bfw = new BufferedWriter(writer);
		for (String key : bkSet) {
			Book bk = (Book) books.get(key);
			String bkString = bk.getBookName() + "," + bk.getBookId() + "," + bk.getNumber() + "\r\n";
			byte[] bytes = null;
			try {
				bytes = bkString.getBytes("GBK");
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

	public boolean insert(elementType etp) {// 添加图书
		Book bk = (Book) etp;
		books.put(bk.getBookId(), bk);
		save();
		return true;
	}

	public boolean delete(elementType etp) {// 删除图书
		Book bk = (Book) etp;
		if (bk != null) {
			String bkId = bk.getBookId();
			BrLibrary brLibrary = BrLibrary.getInstance();
			HashMap<String, elementType> borrows = brLibrary.getAlletps();
			Set<String> keySet = borrows.keySet();
			for (String key : keySet) {
				Borrow borrow = (Borrow) borrows.get(key);
				String[] brFile = borrow.getBookId().split(",");
				for (int i = 0; i < brFile.length; i++) {
					if (bkId.equals(brFile[i])) {
						brLibrary.delete(brFile[i], borrow.getUsername());
					}
				}
			}
			books.remove(bk.getBookId());
			save();
			return true;
		} else {
			save();
			return false;
		}

	}

	public elementType search(String Search) {// 搜书
		StringBuffer br = new StringBuffer();// key相当于bookid
		Set<String> bkSet = books.keySet();
		for (String key : bkSet) {
			Book book = (Book) books.get(key);
			String value = book.getBookName();
			if (value.equals(Search)) {// 如果搜索的是书名
				br.append(key);
			} else if (key.equals(Search)) {// 如果搜索的是id
				br.append(key);
			} else {
				br = null;
			}
		}
		return books.get(br.toString());

	}

	@Override
	public boolean update(elementType etp) {
		return false;
	}

	public HashMap<String, elementType> getAlletps() {
		return books;
	}

	public elementType getEtp(String id) {
		return books.get(id);
	}

}
