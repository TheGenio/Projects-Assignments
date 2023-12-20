package LAB01;

public class TSK1_BOOK {
    public static class Lab01 {
        public static void main(String[] args) {
            Book[] kfupm = new Book[10];

            for (int i = 0; i < 10; i++) {
                int rand = (int) (Math.random()*2 + 1);
                if (rand == 2) {
                    kfupm[i] = new TextBook("MATH", "CALC", 5);
                } else {
                    kfupm[i] = new Book("PHYS", 50);
                }
            }

            // Initialize counters
            int textbookCount = 0;
            int bookCount = 0;

            // Loop through the array to print book information
            for (Book book : kfupm) {
                if (book instanceof TextBook) {
                    System.out.println(book.toString());
                    textbookCount++;
                } else {
                    System.out.println(book.toString());
                    bookCount++;
                }
            }

            // Print the counts of textbooks and regular books
            System.out.println("Number of Textbooks: " + textbookCount);
            System.out.println("Number of Books: " + bookCount);
        }


        public static class Book {
            private String title;
            private int pages;

            public Book() {
                this.title = "Nan";
                this.pages = 0;
            }

            public Book(String title, int page) {
                this.title = title;
                this.pages = page;
            }

            public String getTitle() {
                return title;
            }

            public int getPage() {
                return pages;
            }

            @Override
            public String toString() {
                return "Book: " + title + ", Pages: " + pages;
            }
        }


        static class TextBook extends Book {
            private String course;

            TextBook() {
                super();
                this.course = null;
            }

            TextBook(String course, String title, int pages) {
                super(title, pages);
                this.course = course;
            }

            public String toString() {
                return "TextBook: " + course + super.toString();
            }
        }
    }
}
