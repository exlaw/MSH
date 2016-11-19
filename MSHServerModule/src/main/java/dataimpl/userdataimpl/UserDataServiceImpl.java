package dataimpl.userdataimpl;

import datahelper.DataHelper;
import dataservice.userdataservice.UserDataService;
import po.ClientPO;
import po.CreditPO;
import po.SalesmanPO;
import po.StaffPO;
import util.LoginState;
import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by Kray on 2016/11/17.
 */
public class UserDataServiceImpl implements UserDataService {

    private DataHelper userDataHelper;

    protected UserDataServiceImpl(DataHelper userDataHelper) {
        this.userDataHelper = userDataHelper;
    }

    //TODO 要改
    public LoginState login(String account, String password) {
        System.out.println(account);
        System.out.println(password);
        if(userDataHelper.exactlyQuery(SalesmanPO.class, "account", account) != null
                && userDataHelper.exactlyQuery(SalesmanPO.class, "password", password) != null){
            return LoginState.LOGIN_SUCCESS_Salesman;
        }else if(userDataHelper.exactlyQuery(StaffPO.class, "account", account) != null
                && userDataHelper.exactlyQuery(StaffPO.class, "password", password) != null){
            return LoginState.LOGIN_SUCCESS_Staff;
        }else if(userDataHelper.exactlyQuery(ClientPO.class, "account", account) != null
                && userDataHelper.exactlyQuery(ClientPO.class, "password", password) != null){
            return LoginState.LOGIN_SUCCESS_Client;
        }else{
            return LoginState.LOGIN_FAIL;
        }
    }

    public LoginState logout() {
        return LoginState.LOGOUT;
    }

    public ResultMessage resetPassword(String account, String oldPassword, String newPassword) {
        return null;
    }

    public ResultMessage addClient(ClientPO clientPO, CreditPO creditPO) {
        return null;
    }

    public ClientPO searchClientByID(String clientID) {
        return userDataHelper.exactlyQuery(ClientPO.class, "clientID", clientID);
    }

    public ResultMessage updateClient(String clientID, ClientPO clientPO) {
        return userDataHelper.update(StaffPO.class, clientPO);
    }

    public ResultMessage deleteClient(String clientID) {
        return userDataHelper.delete(ClientPO.class, "clientID", clientID);
    }

    public ArrayList<ClientPO> searchClient(String keyword) {
        ArrayList<ClientPO> clientPOs = new ArrayList<ClientPO>();
        for (ClientPO clientPO : userDataHelper.fuzzyMatchQuery(ClientPO.class, "clientID", keyword)) {
            if (!clientPOs.contains(clientPO)) {
                clientPOs.add(clientPO);
            }
        }
        for (ClientPO clientPO : userDataHelper.fuzzyMatchQuery(ClientPO.class, "clientName", keyword)) {
            if (!clientPOs.contains(clientPO)) {
                clientPOs.add(clientPO);
            }
        }
        for (ClientPO clientPO : userDataHelper.fuzzyMatchQuery(ClientPO.class, "clientID", keyword)) {
            if (!clientPOs.contains(clientPO)) {
                clientPOs.add(clientPO);
            }
        }
        return clientPOs;
    }

    public ResultMessage addStaff(StaffPO staffPO) {
        return userDataHelper.save(StaffPO.class, staffPO);
    }

    public StaffPO searchStaffByID(String staffID) {
        return userDataHelper.exactlyQuery(StaffPO.class, "staffID", staffID);
    }

    public ResultMessage updateStaff(String staffID, StaffPO staffPO) {
        return userDataHelper.update(StaffPO.class, staffPO);
    }

    public ResultMessage deleteStaff(String staffID) {
        return userDataHelper.delete(StaffPO.class, "staffID", staffID);
    }

    public ArrayList<StaffPO> searchStaff(String keyword) {
        ArrayList<StaffPO> staffPOs = new ArrayList<StaffPO>();
        for (StaffPO staffPO : userDataHelper.fuzzyMatchQuery(StaffPO.class, "staffID", keyword)) {
            if (!staffPOs.contains(staffPO)) {
                staffPOs.add(staffPO);
            }
        }
        for (StaffPO staffPO : userDataHelper.fuzzyMatchQuery(StaffPO.class, "staffName", keyword)) {
            if (!staffPOs.contains(staffPO)) {
                staffPOs.add(staffPO);
            }
        }
        for (StaffPO staffPO : userDataHelper.fuzzyMatchQuery(StaffPO.class, "hotelID", keyword)) {
            if (!staffPOs.contains(staffPO)) {
                staffPOs.add(staffPO);
            }
        }
        return staffPOs;
    }

    public ResultMessage addSalesman(SalesmanPO salesmanPO) {
        return userDataHelper.save(SalesmanPO.class, salesmanPO);
    }

    public SalesmanPO searchSalesmanByID(String salesmanID) {
        return userDataHelper.exactlyQuery(SalesmanPO.class, "salesmanID", salesmanID);
    }

    public ResultMessage updateSalesman(String salesmanID, SalesmanPO salesmanPO) {
        return userDataHelper.update(SalesmanPO.class, salesmanPO);
    }

    public ResultMessage deleteSalesman(String salesmanID) {
        return userDataHelper.delete(SalesmanPO.class, "salesmanID", salesmanID);
    }

    public ArrayList<SalesmanPO> searchSalesman(String keyword) {
        ArrayList<SalesmanPO> salesmanPOs = new ArrayList<SalesmanPO>();
        for (SalesmanPO salesmanPO : userDataHelper.fuzzyMatchQuery(SalesmanPO.class, "salesmanID", keyword)) {
            if (!salesmanPOs.contains(salesmanPO)) {
                salesmanPOs.add(salesmanPO);
            }
        }
        for (SalesmanPO salesmanPO : userDataHelper.fuzzyMatchQuery(SalesmanPO.class, "salesmanName", keyword)) {
            if (!salesmanPOs.contains(salesmanPO)) {
                salesmanPOs.add(salesmanPO);
            }
        }
        return salesmanPOs;
    }

    public ResultMessage addCreditRecord(String clientID, CreditPO creditPO) {
        return null;
    }

    public ArrayList<CreditPO> searchCreditByID(String clientID) {
        return null;
    }
}
