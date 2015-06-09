
/*
 *
 * @author Liu Dongyu
 *
 * package下面包括两个类，Book和Library
 * Book类提供4个构造函数初始化，包括一个空白构造函数；
 * Book类还包含书名，作者和页码的getter方法，并且有页码的setter方法；
 *
 * Library类
 * Library类有两个构造函数，可以提供或不提供名字来初始化，并且提供了名字的getter方法；
 * Library类的方法包括，添加书籍，搜索书籍，删除书籍，借阅书籍，归还书籍，打印已有书籍和查询所有图书馆总书籍数目；
 *
 * Library类中用main()函数使用了这两个类的各个场景，每个使用场景的说明都注释在了相应的代码块。
 * 
 * 
 * 程序只是为了尝试满足作业要求，两个类都有大量可优化可扩展空间；
 * 
 * 
 */
package Library;
import java.util.*;
public class Library {
    ArrayList<Book> book;
    private static int bookNumber;
    private final String libraryName;
    public Library(String libraryName){
        this.libraryName = libraryName;
        book = new ArrayList<Book>();
    }
    public Library(){
        this.libraryName = "To be defined";
    }
    public String getLibraryName(){
        return libraryName;
    }
    public void addBooks(Book i){
        book.add(i);
        bookNumber++;
        System.out.println("Book <" + i.getName() + "> has been added to the library " + libraryName);
    }
    public Book searchBook(String bookName){
        Book ans = new Book();
        for(Book temp : book) {
            if (temp.getName() == bookName) {
                System.out.println("Book <" + bookName + "> has been found!");
                ans = temp;
                return ans;
            }
        }
        System.out.println("Could not find the book named <" + bookName + ">! Please try other books.");
        return ans;
    }
    public boolean deleteBook(String bookName){
        if(book.remove(searchBook(bookName))){
            bookNumber--;
            System.out.println("Book <" + bookName + "> has been removed");
            return true;
    }else{
            System.out.println("Book <" + bookName + "> has not been found! Nothing removed" );
            return false;
        }
    }
    public void borrowBook(String bookName){
        if(deleteBook(bookName)){
            System.out.println("Book <" + bookName + "> has been borrowed successfully!");
        }else{
            System.out.println("No such book found!");
        }
    }

    public void returnBook(String bookName){
        Book re = new Book(bookName);
        addBooks(re);
        System.out.println("Book <" + bookName + "> has been returned!");
    }
    public void returnBook(String bookName, String author){
        Book re = new Book(bookName, author);
        addBooks(re);
    }
    public void returnBook(String bookName, String author, String pages){
        Book re = new Book(bookName, author, pages);
        addBooks(re);
    }

    public void bookContained(){
        System.out.println("<" + libraryName + ">" + " contains " + book.size() + " books: ");
        for(Book temp: book){
            System.out.println("<" + temp.getName() + ">" + " written by <" + temp.getAuthor() + ">");
        }
    }

    public void totalBooks(){
        System.out.println("Total book number in all library is: " + bookNumber);
    }

    public static void main(String[] args){

        //define 2 libraries
        Library firstLibrary = new Library("First Library");
        Library secondLibrary = new Library("Second Library");

        //define 4 books to be added to the libraries
        Book theLordOfRings = new Book("The Lord of Rings", "JRR Tolkin");
        Book the1984 = new Book("1984","George Orwell");
        Book aBriefHistoryOfTime = new Book("A Brief History of Time", "Stephen Hawking");
        Book onTheRoad = new Book("On the Road","Jack Kerouac", "784");

        //add three books to the first library
        firstLibrary.addBooks(theLordOfRings);
        firstLibrary.addBooks(the1984);
        firstLibrary.addBooks(onTheRoad);

        //add two books to the second library
        secondLibrary.addBooks(onTheRoad);
        secondLibrary.addBooks(aBriefHistoryOfTime);

        //print all books in the first and second library respectively
        firstLibrary.bookContained();
        secondLibrary.bookContained();


        //borrow books from the first and second library
        firstLibrary.borrowBook("1984");
        secondLibrary.borrowBook("1984");//no such book
        secondLibrary.borrowBook("A Brief History of Time");

        //print the book status after the borrowing behavior before
        firstLibrary.bookContained();
        secondLibrary.bookContained();

        //return 1984 to the first library
        firstLibrary.returnBook("1984", "George Orwell");
        //return total book number
        firstLibrary.totalBooks();


    }
}
