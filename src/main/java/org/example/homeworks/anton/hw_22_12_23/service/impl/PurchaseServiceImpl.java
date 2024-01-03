//package org.example.homeworks.anton.hw_22_12_23.service.impl;
//
//import org.example.homeworks.anton.hw_22_12_23.dao.CrudDao;
//import org.example.homeworks.anton.hw_22_12_23.dao.impl.PurchaseDaoImpl;
//import org.example.homeworks.anton.hw_22_12_23.domain.Purchase;
//import org.example.homeworks.anton.hw_22_12_23.domain.WatchType;
//import org.example.homeworks.anton.hw_22_12_23.service.PurchaseService;
//
//import java.sql.SQLException;
//
//public class PurchaseServiceImpl implements PurchaseService {
//    CrudDao<Purchase> purchaseCrudDao;
//
//    public PurchaseServiceImpl() {
//         purchaseCrudDao = new PurchaseDaoImpl();
//    }
//
//    @Override
//    public void showModelByType(WatchType watchType) throws SQLException {
//       purchaseCrudDao.showModelByType(watchType);
//    }
//}
