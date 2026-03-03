public class Book extends OfficeSupplies {

    private String publisher;
    private String authors;
    private int pages;

    public Book(double price, int stock,
                String releaseDate, String coverTitle) {

        super(price, stock, releaseDate, coverTitle);
        this.publisher = publisher;
        this.authors = authors;
        this.pages = pages;
    }

    @Override
    public String getInfo() {
        return "Book{id=" + id +
                ", title=" + coverTitle +
                ", price=" + price +
                ", stock=" + stock +
                ", publisher=" + publisher +
                ", authors=" + authors +
                ", pages=" + pages +
                "}";
    }
}
