package ex3.booksmanagement.view;

import ex3.booksmanagement.controller.ControllerUtility;
import ex3.booksmanagement.controller.DataController;
import ex3.booksmanagement.model.Book;
import ex3.booksmanagement.model.BookReaderManagement;
import ex3.booksmanagement.model.Reader;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        var booksFileName = "BOOK.DATA";
        var readersFileName = "READER.DATA";
        var brmsFileName = "BRM.DATA";

        var controller = new DataController();

        var books = new ArrayList<Book>();
        var readers = new ArrayList<Reader>();
        var brms = new ArrayList<BookReaderManagement>();

        var isBookChecked = false;
        var isReaderChecked = false;

        do {
            System.out.println("____________________MENU____________________");
            System.out.println("1. Thêm một đầu sách vào File.");
            System.out.println("2. Hiển thị danh sách các sách có trong File.");
            System.out.println("3. Thêm một bạn đọc vào File.");
            System.out.println("4. Hiển thị danh sách các bạn đọc có trong File.");
            System.out.println("5. Lập thông tin quản ý mượn.");
            System.out.println("0. Thoát ứng dụng.");
            System.out.println("Ban chọn? ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("________________________________________________");
                    System.out.println("Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi!");
                    break;

                case 1:
                    /*int bookID, String bookName, String author, String specialization, int publishYear, int quantity*/

                    if (!isBookChecked == true) {
                        checkBookId(controller, booksFileName);
                        isBookChecked = true;
                    }

                    String bookName, author, specialization;
                    String[] specializations = {"Science", "Art", "Economic", "IT"};
                    int number = 0; // So thu tu cua the loai sach
                    int publishYear, quantity;

                    System.out.println("Enter the Book Name: ");
                    bookName = scanner.nextLine();

                    System.out.println("Enter the Author: ");
                    author = scanner.nextLine();

                    do {
                        System.out.println("Apecialization: ");
                        System.out.println(" 1.Science\n 2.Art\n 3.Economic\n 4.IT");
                        System.out.println("Enter the Specialization: ");
                        number = scanner.nextInt();

                    } while (number < 1 || number > 4);
                    specialization = specializations[number - 1];

                    System.out.println("Enter the Publish Year: ");
                    publishYear = scanner.nextInt();

                    System.out.println("Enter the Quantity: ");
                    quantity = scanner.nextInt();

                    Book book = new Book(0, bookName, author, specialization, publishYear, quantity);
                    controller.writeBookToFile(book, booksFileName);
                    break;

                case 2:
                    books = controller.readBooksFromFile(booksFileName);
                    showBooksInfo(books);
                    break;

                case 3:
                    /**int readerID, String fullName, String address, String phoneNumber*/

                    if (!isReaderChecked) {
                        checkReaderId(controller, readersFileName);
                        isReaderChecked = true;
                    }

                    String fullName, address, phoneNumber;

                    System.out.println("Enter Full Name: ");
                    fullName = scanner.nextLine();

                    System.out.println("Enter the Address: ");
                    address = scanner.nextLine();

                    do {
                        System.out.println("Enter the Phone Number: ");
                        phoneNumber = scanner.nextLine();
                    } while (!phoneNumber.matches("\\d{10}"));

                    Reader reader = new Reader(0, fullName, address, phoneNumber);
                    controller.writeReaderToFile(reader, readersFileName);
                    break;

                case 4:
                    readers = controller.readReadersFromFile(readersFileName);
                    showReadersInfo(readers);
                    break;

                case 5:
                    //B0:
                    books = controller.readBooksFromFile(booksFileName);
                    readers = controller.readReadersFromFile(readersFileName);
                    brms = controller.readBRMsFromFile(brmsFileName);

                    //B1:
                    int bookID, readerID;
                    boolean isBrrowable = false;
                    do {
                        showReadersInfo(readers);
                        System.out.println("Nhập mã bạn đọc, nhập 0 để bỏ qua: ");
                        readerID = scanner.nextInt();
                        if (readerID == 0) {
                            break;
                        }
                        isBrrowable = checkBrrowed(brms, readerID);
                        if (isBrrowable) {
                            break;
                        } else {
                            System.out.println("Bạn đọc này đã mượn đủ số lượng cho phép.");
                        }
                    } while (true);

                    //B2:
                    boolean isFull = false;
                    do {
                        showBooksInfo(books);
                        System.out.println("_______________________________________________");
                        System.out.println("Nhập mã sách, nhập 0 để bỏ qua.");
                        bookID = scanner.nextInt();
                        if (bookID == 0) {
                            break;
                        }

                        isFull = checkFull(brms, readerID, bookID);
                        if (!isFull) {
                            break;
                        } else {
                            System.out.println("Vui lòng chọn đầu sách khác.");
                        }

                    } while (true);

                    //B3:
                    int total = getTotal(brms, readerID, bookID);
                    do {
                        System.out.println("Số lượng mượn, tối đa 3 cuốn (đã mượn " + total + " ):");
                        int x = scanner.nextInt();
                        if ((x + total) >= 1 && (x + total) <= 3) {
                            total += x;
                            break;
                        } else {
                            System.out.println("Nhập sai số lượng cho phép. Yêu cầu nhập lại.");
                        }
                    } while (true);
                    scanner.nextLine(); //Doc bo dong co chua so

                    System.out.println("Nhập tình trạng: ");
                    String status = "";
                    status = scanner.nextLine();

                    //B4: Reader reader, Book book, int numOfBorrow, String state, int totalOfBorrowred
                    Book currentBook = getBook(books, bookID);
                    Reader currentReader = getReader(readers, readerID);

                    BookReaderManagement b = new BookReaderManagement(currentReader,
                            currentBook, total, status, 0);

                    var ultility = new ControllerUtility();
                    brms = ultility.updateBRMInfo(brms, b); //Cap nhat danh sach quan ly muon
                    controller.updateBRMFile(brms, brmsFileName);//cap nhat file

                    //B5:
                    showBRMInfo(brms);
            }
            break;
        } while (choice != 0);
    }

    private static void showBRMInfo(ArrayList<BookReaderManagement> brms) {
        System.out.println("_____________________________________________");
        for (var brm : brms) {
            System.out.println(brm);
        }
    }

    private static Reader getReader(ArrayList<Reader> readers, int readerID) {
        for (int i = 0; i < readers.size(); i++) {
            if (readers.get(i).getReaderID() == readerID) {
                return readers.get(i);
            }
        }
        return null;
    }

    private static Book getBook(ArrayList<Book> books, int bookID) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookID() == bookID) {
                return books.get(i);
            }
        }
        return null;
    }

    private static int getTotal(ArrayList<BookReaderManagement> brms, int readerID, int bookID) {
        for (var r : brms) {
            if (r.getReader().getReaderID() == readerID && r.getBook().getBookID() == bookID) {
                return r.getNumOfBorrow();
            }
        }
        return 0;
    }

    private static boolean checkFull(ArrayList<BookReaderManagement> brms, int readerID, int bookID) {
        for (var r : brms) {
            if (r.getReader().getReaderID() == readerID && r.getBook().getBookID() == bookID
                    && r.getNumOfBorrow() >= 3) {
                return true; // Khong duoc muon
            }
        }

        return false;// Duoc muon
    }

    private static boolean checkBrrowed(ArrayList<BookReaderManagement> brms, int readerID) {
        int count = 0;
        for (var r : brms) {
            if (r.getReader().getReaderID() == readerID) {
                count += r.getNumOfBorrow();
            }
        }
        if (count >= 15) {
            return false; //Khong duoc phep muon
        }
        return true;//duoc phep muon
    }

    private static void showReadersInfo(ArrayList<Reader> readers) {
        System.out.println("_________________Thông tin người mượn sách trong File_________________");
        for (var r : readers) {
            System.out.println(r);
        }
        System.out.println("______________________________________________________________________");
    }

    private static void checkReaderId(DataController controller, String readersFileName) {
        var listReaders = controller.readReadersFromFile(readersFileName);
        if (listReaders.size() == 0) {
            // do nothing
        } else {
            Reader.setId(listReaders.get(listReaders.size() - 1).getReaderID() + 1);
        }
    }

    private static void checkBookId(DataController controller, String booksFileName) {
        var listBooks = controller.readBooksFromFile(booksFileName);
        if (listBooks.size() == 0) {
            //do nothing
        } else {
            Book.setId(listBooks.get(listBooks.size() - 1).getBookID() + 1);
        }
    }

    private static void showBooksInfo(ArrayList<Book> books) {
        System.out.println("_________________Thông tin sách trong File_________________");
        for (var b : books) {
            System.out.println(b);
        }
        System.out.println("___________________________________________________________");
    }
}

