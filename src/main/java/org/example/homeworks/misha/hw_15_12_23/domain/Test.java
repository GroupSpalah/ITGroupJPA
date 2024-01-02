package org.example.homeworks.misha.hw_15_12_23.domain;

import lombok.SneakyThrows;
import org.example.homeworks.misha.hw_15_12_23.service.NotebookService;
import org.example.homeworks.misha.hw_15_12_23.service.imp.NotebookServiceImpl;

public class Test {
    @SneakyThrows
    public static void main(String[] args) {
        NotebookService notebookDAO = new NotebookServiceImpl();
        //notebookDAO.add();
        //notebookDAO.showForID(2);
        //notebookDAO.showAll();
        //notebookDAO.deleteForID(1);
        //notebookDAO.deleteAll();
        //notebookDAO.updateForId(52);
        //notebookDAO.showForModel("FG5");
        //notebookDAO.showForDate("2021-11-02");
        //notebookDAO.showForRamAndSsd(8, 512);
        notebookDAO.showForCpu("CPU28");
    }
}
