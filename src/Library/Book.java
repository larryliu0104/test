package Library;

public class Book {
    private String bookName;
    private String author;
    private String pages;
    Book(){

    }

    Book(String bookName){
        this.bookName = bookName;
    }
    Book(String bookName, String author){
        this.bookName = bookName;
        this.author = author;
    }
    Book(String bookName, String author, String pages){
        this.bookName = bookName;
        this.author = author;
        this.pages = pages;
    }
    public String getName(){
        return bookName;
    }
    public String getAuthor(){
        return author;
    }


    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPages() {
        return pages;
    }

}
