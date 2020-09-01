package ex3.booksmanagement.controller;

import ex3.booksmanagement.model.BookReaderManagement;

import java.util.ArrayList;

public class ControllerUtility {
    public ArrayList<BookReaderManagement> updateBRMInfo(ArrayList<BookReaderManagement> list,
                                                         BookReaderManagement brm) {
        boolean isUpdated = false;

        for (int i = 0; i < list.size(); i++) {
            BookReaderManagement b = list.get(i);
            if (b.getReader().getReaderID() == brm.getReader().getReaderID()) {
                list.set(i, brm); // Cap nhat lai doi tuong quan ly muon
            }
        }
        if (!isUpdated) {
            list.add(brm);
        }
        return list;
    }
}
