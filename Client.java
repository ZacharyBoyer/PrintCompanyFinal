/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Zach
 */
public class Client {
    int id, AgentId;
    String FirstName, LastName, StreetNumber, StreetName, City, Province, PostalCode, TelOffice, TelCell, Email, Company, CompanyType;
    
    public Client(){
        
    }
    //constructor with id property
    public Client(int id, int AgentId, String FirstName, String LastName, String StreetNumber, String StreetName, String City, String Province, String PostalCode, String TelOffice, String TelCell, String Email, String Company, String CompanyType){
      this.id = id;
      this.AgentId =  AgentId;
      this.FirstName = FirstName;
      this.LastName = LastName;
      this.StreetNumber = StreetNumber;
      this.StreetName = StreetName;
      this.City = City;
      this.Province = Province;
      this.PostalCode = PostalCode;
      this.TelOffice = TelOffice; 
      this.TelCell = TelCell;
      this.Email = Email;
      this.Company = Company;
      this.CompanyType = CompanyType;
    }
    //constructor without id property
    public Client(int AgentId, String FirstName, String LastName, String StreetNumber, String StreetName, String City, String Province, String PostalCode, String TelOffice, String TelCell, String Email, String Company, String CompanyType){
      this.AgentId =  AgentId;
      this.FirstName = FirstName;
      this.LastName = LastName;
      this.StreetNumber = StreetNumber;
      this.StreetName = StreetName;
      this.City = City;
      this.Province = Province;
      this.PostalCode = PostalCode;
      this.TelOffice = TelOffice; 
      this.TelCell = TelCell;
      this.Email = Email;
      this.Company = Company;
      this.CompanyType = CompanyType;
    }
    
    //getter and setter methods for client
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAgentId() {
        return AgentId;
    }

    public void setAgentId(int AgentId) {
        this.AgentId = AgentId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getStreetNumber() {
        return StreetNumber;
    }

    public void setStreetNumber(String StreetNumber) {
        this.StreetNumber = StreetNumber;
    }

    public String getStreetName() {
        return StreetName;
    }

    public void setStreetName(String StreetName) {
        this.StreetName = StreetName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String Province) {
        this.Province = Province;
    }
    
    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String PostalCode) {
        this.PostalCode = PostalCode;
    }
    public String getTelOffice() {
        return TelOffice;
    }

    public void setTelOffice(String TelOffice) {
        this.TelOffice = TelOffice;
    }

    public String getTelCell() {
        return TelCell;
    }

    public void setTelCell(String TelCell) {
        this.TelCell = TelCell;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public String getCompanyType() {
        return CompanyType;
    }

    public void setCompanyType(String CompanyType) {
        this.CompanyType = CompanyType;
    }
}
