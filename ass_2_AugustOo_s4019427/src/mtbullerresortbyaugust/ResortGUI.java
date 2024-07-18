/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mtbullerresortbyaugust;


import java.awt.*;
import java.awt.event.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

/**
 *
 * @author August Oo
 * @version 1.0
 * 
 */
public class ResortGUI extends JFrame implements ActionListener{
    private ArrayList<Accommodation> accommodations;
    private ArrayList<Customer> customers;
    private ArrayList<TravelPackage> packages;
    private ArrayList<LiftPass> liftpasses;
    
    

    //GUI components
    //JTabbedPane
    private JTabbedPane tabbedPane;
    private JPanel customersTab;
    private JPanel travelPackageTab;
    
    //GUI component for CustomerTab
    private JPanel mainPanel, detailPanel, searchRemovePanel, listPanel;
    private JLabel lblFirstName;
    private JTextField txtFirstName;
    private JLabel lblLastName;
    private JTextField txtLastName;
    
    private JLabel lblContact;
    private JTextField txtContact;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblAddress;
    private JTextField txtAddress;
    private JLabel lblSkiingLevel;
    private JComboBox<String> skiingLevelCmboBox;
    private JScrollPane scrollPane;
    private JLabel lblCustomerID;
    private JTextField txtcustomerIdField;
    private JButton searchButton, removeButton;
    
    private JButton btnAddCustomer;
    private JButton btnListCustomers;
    private JButton btnClearCustomers;
    private JTextArea txtAreaCustomers;
    
    //GUI component for Accommodation Tab
    private JPanel accommodationsTab,checkBoxPanel,accommodationListPanel;
    private JPanel acmButtonPanel,imagePanel,searchAndRemovePanel;
    private JScrollPane accScrollPane;
            
    
    private JButton btnDisplayAcc;
    private JButton btnDisplayAvailableAcc;
    private JScrollPane accremoveScrollPane;
    private JCheckBox hotelCheckBox,hostelCheckBox,lodgeCheckBox,apartmentCheckBox;
    private JTextArea accommodationTextArea;
   
    private JList<String> accommodationList;
    private JLabel imageLabel;
    private DefaultListModel<String> listModel;
    
    private JLabel lblAccommodationID, imageName ;
    private JTextField txtAccID;
    private JButton searchAccommodation, removeAccommodation;
    
    //GUI components for Travel Package Tab
    private JComboBox<Customer> customerComboBox;
    private JComboBox<Accommodation> accommodationComboBox;
    private JLabel selectAcc, selectCustomer, startDate, duration;
    private JTextField startDateField;
    private JTextField durationField;
    private JTextArea packageListArea;
    private JButton createPackageButton, listPackagesButton;
    //GUI component for lessonPanel
    private JPanel lessonPanel;
    private JLabel packageIdLabel, noOfLesson;
    private JLabel viewLessonFeesLabel;
    private JTextField packageIdField;
    private JButton lessonFees, addLessonButton, searchPackage;
    private JComboBox<Integer> lessondays;
    
    //GUI component for liftPassPanel
    private JPanel liftPassPanel;
    private JLabel liftPassTypeLabel, viewliftPassFeesLabel;
    private JComboBox<Integer> liftPassTypeComboBox;
    private JLabel dayLabel, packageLabel ;
    private JComboBox<TravelPackage> packageComboBox, travelPackageComboBox;
    private JComboBox<Integer> dayComboBox;
    private JButton addLiftPassButton, liftPassFeebtn;
    
    //Save and Read Package 
    private JButton savePackage, readPackage;  
    private FileInputStream fis;
    private ObjectInputStream ois;
    private FileOutputStream fos;
    private ObjectOutputStream oos;

            
    
    public ResortGUI() {
        this.accommodations = new ArrayList<Accommodation>();
        this.customers = new ArrayList<Customer>();
        this.packages = new ArrayList<TravelPackage>();
        this.liftpasses = new ArrayList<LiftPass>();
        
        
        setTitle("Mt Buller winter Resort");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();
        populateList();


        //accommodation Tab
        accommodationsTab = new JPanel();
        tabbedPane.addTab("Accommondation", accommodationsTab);
        accommodationsTab();
        
        // Customers Tab
        customersTab = new JPanel();
        tabbedPane.addTab("Customer", customersTab);
        customersTab();

        
        travelPackageTab = new JPanel();
        tabbedPane.addTab("Travel Package", travelPackageTab);
        travelPackageTab();



        add(tabbedPane);
        
        
        
    }
    
    private void populateList() {
        
            accommodations.add(new Accommodation( "Hotel", 200,"acc1.jpg","Cawarra Hotel"));
            accommodations.add(new Accommodation( "Lodge", 150, "lodge.jpg","Ivor Whittaker Lodge"));
            accommodations.add(new Accommodation("Apartment", 90,"acc10.jpg", "Kooroora Apartment"));
            accommodations.add(new Accommodation("Hostel",100, "acc4.jpg", "Amber Hostel"));
            accommodations.add(new Accommodation("Hotel",500, "acc5.jpg","Benmore Hotel"));
            accommodations.add(new Accommodation( "Hostel", 80, "acc6.jpg","Panorama Hostel"));
            accommodations.add(new Accommodation( "Apartment", 75, "apartment2.jpg","Malamute Apartment"));
            accommodations.add(new Accommodation("Apartment", 50, "apartment3.jpg","SnowFlake Apartment"));
            accommodations.add(new Accommodation("Lodge",250, "acc9.jpg","Jungfrau Lodge"));
            accommodations.add(new Accommodation("Hotel",120, "hotel.jpg","Coonamar Hotel"));
            
            
            
        
        Customer[] arrOfCustomers = {
            new Customer( "Amma","Watson", "0412345678", "emma@gmail.com", "30 Madison Drive, Hoppers Crossing","Beginner"),
            new Customer("Tylor", "Smith","0455532233","tylor@gmail.com","10 Rose Street, Williams Landing", "Intermediate"), 
            new Customer( "Alice", "May","0499847444","alice@gmail.com","100 Geelong Street, Melbourne", "Expert")};
        
        for(int i = 0; i < arrOfCustomers.length; i++)
            customers.add(arrOfCustomers[i]);

    }
    
    

    private void customersTab(){
        //set layout
        customersTab.setLayout(new BorderLayout());
        detailPanel = new JPanel(new BorderLayout());
        
        JPanel inputPanel = new JPanel(new GridLayout(6,2,10,5));
        lblFirstName = new JLabel("First Name:");
        txtFirstName = new JTextField(15);
        lblLastName = new JLabel("Last Name:");
        txtLastName = new JTextField(15);
        lblContact = new JLabel("Contact Number<0412345678>:");
        txtContact = new JTextField(15);
        lblEmail = new JLabel("Email:");
        txtEmail = new JTextField(15);
        lblAddress = new JLabel("Address:");
        txtAddress = new JTextField(15);
        
        lblSkiingLevel = new JLabel("Skiing Level:");
        skiingLevelCmboBox = new JComboBox<>(new String[]{"Beginner", "Intermediate", "Expert"});
        
        // initialise buttons
        JPanel btnCustomerPanel = new JPanel(new GridLayout(1,3,10,10));
        btnAddCustomer = new JButton("Add Customer");
        btnListCustomers = new JButton("List Customers");
        btnClearCustomers = new JButton("Clear");
        
       
        
        
        // add componets to panel
        inputPanel.add(lblFirstName);
        inputPanel.add(txtFirstName);
        inputPanel.add(lblLastName);
        inputPanel.add(txtLastName);
        inputPanel.add(lblContact);
        inputPanel.add(txtContact);
        inputPanel.add(lblEmail);
        inputPanel.add(txtEmail);
        inputPanel.add(lblAddress);
        inputPanel.add(txtAddress);

        inputPanel.add(lblSkiingLevel);
        inputPanel.add(skiingLevelCmboBox);
        detailPanel.add(inputPanel, BorderLayout.NORTH);
        
        btnCustomerPanel.add(btnAddCustomer);
        btnCustomerPanel.add(btnListCustomers);
        btnCustomerPanel.add(btnClearCustomers);
        btnCustomerPanel.setBorder(new TitledBorder("Action Buttons"));
        detailPanel.add(btnCustomerPanel, BorderLayout.SOUTH);
        
        customersTab.add(detailPanel,BorderLayout.NORTH);
        detailPanel.setBorder(new TitledBorder("Add and List Customer Details"));
        
        //search Panel
        searchRemovePanel = new JPanel(new BorderLayout());
        JPanel inputSearchRemovePanel = new JPanel(new GridLayout(1,2,10,10));
        lblCustomerID = new JLabel("Customer ID");
        txtcustomerIdField =new JTextField();
        JPanel searchandRemoveButtonPanel = new JPanel(new GridLayout(1,2));
        searchButton = new JButton("Search Customer");
        removeButton = new JButton("Remove Customer");
        inputSearchRemovePanel.add(lblCustomerID);
        inputSearchRemovePanel.add(txtcustomerIdField);
        searchRemovePanel.add(inputSearchRemovePanel,BorderLayout.NORTH);
        searchandRemoveButtonPanel.add(searchButton);
        searchandRemoveButtonPanel.add(removeButton);
        searchandRemoveButtonPanel.setBorder(new TitledBorder("Action Buttons"));
        searchRemovePanel.add(searchandRemoveButtonPanel,BorderLayout.SOUTH);
        customersTab.add(searchRemovePanel, BorderLayout.SOUTH);
        searchRemovePanel.setBorder(new TitledBorder("Search/Remove Customer"));
        
        listPanel = new JPanel(new BorderLayout());
        //initialise txt area
        txtAreaCustomers = new JTextArea(10,2);
        txtAreaCustomers.setEditable(false);
        scrollPane = new JScrollPane(txtAreaCustomers);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        listPanel.add(scrollPane,BorderLayout.CENTER);
        customersTab.add(listPanel);
        listPanel.setBorder(new TitledBorder("Customer Details"));

        // Attach action listeners to customer-related buttons
        btnAddCustomer.addActionListener(this);
        btnListCustomers.addActionListener(this);
        btnClearCustomers.addActionListener(this);
        searchButton.addActionListener(this);
        removeButton.addActionListener(this);
                
        
                
    }
    
    private void accommodationsTab() {
        accommodationsTab.setLayout(new BorderLayout());
        checkBoxPanel = new JPanel(new GridLayout(1,4,0,10));
        // Initialize checkboxes 
        hotelCheckBox = new JCheckBox("Hotel");
        hostelCheckBox = new JCheckBox("Hostel");
        apartmentCheckBox = new JCheckBox("Apartment");
        lodgeCheckBox = new JCheckBox("Lodge");

        // Checkboxes panel setup
        checkBoxPanel.add(hotelCheckBox);
        checkBoxPanel.add(hostelCheckBox);
        checkBoxPanel.add(apartmentCheckBox);
        checkBoxPanel.add(lodgeCheckBox);
        checkBoxPanel.setBorder(new TitledBorder("Select check box"));
        accommodationsTab.add(checkBoxPanel, BorderLayout.NORTH);
        
        //Center Panel
        JPanel centralPanel = new JPanel(new BorderLayout());
        accommodationsTab.add(centralPanel, BorderLayout.CENTER);
        //Display Accommodation List 
        JPanel outlineDisplayList = new JPanel(new GridLayout(1,2,10,10));
        centralPanel.add(outlineDisplayList,BorderLayout.CENTER);

        accommodationListPanel = new JPanel(new BorderLayout());
        listModel = new DefaultListModel<>();
        accommodationList = new JList<>(listModel);
        accScrollPane = new JScrollPane(accommodationList);
        accommodationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        accScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        accScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        accommodationListPanel.add(accScrollPane);
        outlineDisplayList.add(accommodationListPanel);
        
        accommodationListPanel.setBorder(new TitledBorder("Accommodation List"));


        // Image label setup
        imagePanel = new JPanel();
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        imageLabel.setPreferredSize(new Dimension(400,300));
        imagePanel.setBorder(new TitledBorder("Accommodation Image"));
        imageName = new JLabel();
        imagePanel.add(imageName, BorderLayout.SOUTH);
        outlineDisplayList.add(imagePanel);
        //accommodationsTab.add(centralPanel,BorderLayout.CENTER);
         // Accommodations Button Panel
        acmButtonPanel = new JPanel(new GridLayout(1,2,10,10));
        btnDisplayAcc = new JButton("Display All Accommodations");
        btnDisplayAvailableAcc = new JButton("Display Available Accommodations");
        acmButtonPanel.add(btnDisplayAcc);
        acmButtonPanel.add(btnDisplayAvailableAcc);
        acmButtonPanel.setBorder(new TitledBorder("Action Buttons"));
        centralPanel.add(acmButtonPanel, BorderLayout.SOUTH);
        

        //Search and Remove Accommodation Panel
        searchAndRemovePanel = new JPanel(new BorderLayout());
        JPanel inputSearchPanel = new JPanel(new BorderLayout());
        JPanel buttonSearchPanel = new JPanel(new BorderLayout());
        accommodationsTab.add(searchAndRemovePanel, BorderLayout.SOUTH);
        searchAndRemovePanel.setBorder(new TitledBorder("Search and Remove Accommodation"));
       
       
        inputSearchPanel = new JPanel(new GridLayout(1,2));
        lblAccommodationID = new JLabel("Enter Accommodation ID: ");
        txtAccID =new JTextField(10);
        searchAccommodation = new JButton("Search Accommodation");
        removeAccommodation = new JButton("Remove Accommodation");
        
        
        inputSearchPanel.add(lblAccommodationID);
        inputSearchPanel.add(txtAccID);
        buttonSearchPanel = new JPanel(new GridLayout(1,2));
        buttonSearchPanel.add(searchAccommodation);
        buttonSearchPanel.add(removeAccommodation);
        
        accommodationTextArea = new JTextArea(5,2);
        accommodationTextArea.setEditable(false);
        
        accremoveScrollPane = new JScrollPane(accommodationTextArea);
        accremoveScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        accremoveScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        accremoveScrollPane.setBorder(new TitledBorder("Accommodation Details"));
        
         //Display Accommodation List 
        searchAndRemovePanel.add(buttonSearchPanel,BorderLayout.SOUTH);
        searchAndRemovePanel.add(inputSearchPanel,BorderLayout.NORTH);
        searchAndRemovePanel.add(accremoveScrollPane,BorderLayout.CENTER);
        
        //add Action listener for btn
        btnDisplayAcc.addActionListener(this);
        btnDisplayAvailableAcc.addActionListener(this);
        searchAccommodation.addActionListener(this);
        removeAccommodation.addActionListener(this);
        //Action listener for CheckBox
        hotelCheckBox.addActionListener(this);
        hostelCheckBox.addActionListener(this);
        apartmentCheckBox.addActionListener(this);
        lodgeCheckBox.addActionListener(this);
        
// Add list selection listener
        accommodationList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && accommodationList.getSelectedIndex() != -1) {
                    String selectedAccommodation = accommodationList.getSelectedValue();
                    updateImageDisplay(selectedAccommodation);
                }
            }
        });

    }
    private void travelPackageTab(){
        
        travelPackageTab.setLayout(new BorderLayout());
        JPanel travelpanel = new JPanel(new BorderLayout());
        travelPackageTab.add(travelpanel, BorderLayout.NORTH);
        JPanel inputTravelPanel = new JPanel(new GridLayout(4,2,10,10));
        selectCustomer = new JLabel("Select Customer");
        customerComboBox = new JComboBox<>(new DefaultComboBoxModel<>(customers.toArray(Customer[]::new)));
        
        selectAcc = new JLabel("Select Accommodation");
        accommodationComboBox = new JComboBox<>(new DefaultComboBoxModel<>(
        accommodations.stream().filter(Accommodation::getAvailability).toArray(Accommodation[]::new)));
        
        startDate = new JLabel("Start Date(yyyy-mm-dd)");
        startDateField = new JTextField();
        
        duration = new JLabel("Duration(days):");
        durationField = new JTextField();
        
        //add inputTravelPanel to travelPanel
        inputTravelPanel.add(selectCustomer);
        inputTravelPanel.add(customerComboBox);
        inputTravelPanel.add(selectAcc);
        inputTravelPanel.add(accommodationComboBox);
        inputTravelPanel.add(startDate);
        inputTravelPanel.add(startDateField);
        inputTravelPanel.add(duration);
        inputTravelPanel.add(durationField);
        travelpanel.add(inputTravelPanel,BorderLayout.NORTH);
        
        JPanel createPackage = new JPanel(new GridLayout(1,2,5,5));
        JPanel saveReadPackage = new JPanel(new GridLayout(2,1,10,10));
        JPanel addListPackage = new JPanel(new GridLayout(2,1,10,10));
        createPackageButton = new JButton("Create a Package");
        listPackagesButton =new JButton("List Packages");
        savePackage = new JButton ("Save Packages");
        readPackage = new JButton("Read Packages");
        
        addListPackage.add(createPackageButton);
        addListPackage.add(listPackagesButton);
        saveReadPackage.add(savePackage);
        saveReadPackage.add(readPackage);
        saveReadPackage.setBorder(new TitledBorder("Save and Read Package"));
        addListPackage.setBorder(new TitledBorder("Add and List Package"));
        createPackage.setBorder(new TitledBorder("Action Buttons"));
        createPackage.add(addListPackage);
        createPackage.add(saveReadPackage);
        travelpanel.add(createPackage,BorderLayout.SOUTH);
        travelpanel.setBorder(new TitledBorder("Add Package"));
        
        packageListArea = new JTextArea(20,40);
        packageListArea.setEditable(false);
        JScrollPane pacScrollPane = new JScrollPane(packageListArea);
        pacScrollPane.setBorder(BorderFactory.createTitledBorder("List of Packages"));
        pacScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pacScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        travelPackageTab.add(pacScrollPane, BorderLayout.CENTER);
        
        JPanel mainSouthPanel = new JPanel(new BorderLayout(1,2));
        mainSouthPanel = new JPanel(new GridLayout(1,2));
        JPanel actLiftPass = new JPanel(new GridLayout(1,2));
        
        //setupLessonPanel
        lessonPanel = new JPanel(new GridLayout(4,2,10,10));
        JPanel actForLesson = new JPanel(new GridLayout(1,1,10,10));
        packageIdLabel = new JLabel("Select Package: ");
        travelPackageComboBox = new JComboBox<>(new DefaultComboBoxModel<>(packages.toArray(new TravelPackage[0])));

        packageIdField = new JTextField(10);
        viewLessonFeesLabel = new JLabel("View Lesson Fee: ");
        lessonFees = new JButton("Click to view LessonFee");
        noOfLesson = new JLabel("Select no of Lesson");
        lessondays = new JComboBox<>();
        for (int i = 1; i <=10; i++){
            lessondays.addItem(i);
        }

        
        addLessonButton = new JButton("Add Lesson Fee");
        actForLesson.add(addLessonButton,BorderLayout.NORTH);
        actForLesson.setBorder(new TitledBorder("Action Button"));
        
        lessonPanel.add(viewLessonFeesLabel);
        lessonPanel.add(lessonFees);
        lessonPanel.add(packageIdLabel);
        lessonPanel.add(travelPackageComboBox);
        lessonPanel.add(noOfLesson);
        lessonPanel.add(lessondays);
        lessonPanel.add(actForLesson);
        mainSouthPanel.add(lessonPanel);
        
        lessonPanel.setBorder(new TitledBorder("Add Lesson Fees to Package (Optional)"));
        
        
        //setup LiftPass Panel
        liftPassPanel = new JPanel(new GridLayout(4,2,10,10));
        liftPassTypeLabel = new JLabel("Select Number of Days");
        liftPassTypeComboBox = new JComboBox<>();
        for (int i = 1; i <=30; i++){
            liftPassTypeComboBox.addItem(i);
        }
        
        
        packageLabel = new JLabel("Select Package:");
        packageComboBox = new JComboBox<>(new DefaultComboBoxModel<>(packages.toArray(TravelPackage[]::new)));
        viewliftPassFeesLabel = new JLabel("View LiftPass Fee");
        liftPassFeebtn = new JButton("Check LiftPass Fees");
        
        addLiftPassButton = new JButton("Add Lift Pass");

        
        
        
        liftPassPanel.add(viewliftPassFeesLabel);
        liftPassPanel.add(liftPassFeebtn);
        liftPassPanel.add(packageLabel);
        liftPassPanel.add(packageComboBox);
        liftPassPanel.add(liftPassTypeLabel);
        liftPassPanel.add(liftPassTypeComboBox);
        
        actLiftPass.add(addLiftPassButton,BorderLayout.NORTH);
        actLiftPass.setBorder(new TitledBorder("Action Button"));
        liftPassPanel.add(actLiftPass);
        liftPassPanel.setBorder(new TitledBorder("Add a Lift Pass to Package(Optional)"));
        mainSouthPanel.add(liftPassPanel);
        travelPackageTab.add(mainSouthPanel,BorderLayout.SOUTH);

        
        createPackageButton.addActionListener(this);
        listPackagesButton.addActionListener(this);
        addLessonButton.addActionListener(this);
        lessonFees.addActionListener(this);
        liftPassFeebtn.addActionListener(this);
        addLiftPassButton.addActionListener(this);
        savePackage.addActionListener(this);
        readPackage.addActionListener(this);
        
        
    }
    
    
    
    //Add Customer
    private void addCustomer(String firstName,String lastName, String contactNo, String email, String address, String skiingLevel) {
        txtAreaCustomers.setText("");
        boolean validContact = isValidContact(contactNo);
        if (validContact) {
            Customer c = new Customer(firstName, lastName,contactNo, email, address, skiingLevel);
            customers.add(c);
            updateCustomerComboBox();
            startDateField.setText("");
            durationField.setText("");
            txtFirstName.setText("");
            txtLastName.setText("");
            txtContact.setText("");
            txtEmail.setText("");
            txtAddress.setText("");
            //txtAreaCustomers.append(c.toString() + "\n");
            JOptionPane.showMessageDialog(null, "Successful add Customer.");
        } else if (firstName.isEmpty() || lastName.isEmpty() || contactNo.isEmpty() || email.isEmpty() || address.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Please fill all fields correctly.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            else {
            JOptionPane.showMessageDialog(null, "Customer data is not added.");
            if (!validContact) {
                JOptionPane.showMessageDialog(null, "Invalid contact number. Please enter a 10-digit number starting with 04.");
            }
        }
        
    }

    
    //contact error handeling
    private boolean isValidContact(String contact) {
        boolean valid = contact.matches("^04\\d{8}$");
        return valid;
    }
    
    // Method to list all customers
    public void listCustomers() {
        txtAreaCustomers.setText("");
        
        if (customers.isEmpty()) {           
        txtAreaCustomers.setText("No customers founded.");
        JOptionPane.showMessageDialog(null, "No Customer found.");
        
        } else {
        // List all customers
        for (Customer customer : customers) {
            txtAreaCustomers.append("\nCustomer Details: " + "\nID: " + customer.getCustId()
            + "\nName: " + customer.getFirstName() + " " + customer.getLastName()
            + "\nSkiing Level: " + customer.getSkiingLevel() + "\nContact No: " + customer.getContact()
            + "\nEmail: " + customer.getEmail() + "\n");
            
        }
        
    }
    }


    public void searchCustomerbyID(String id) {
        
        txtAreaCustomers.setText("");
        if (id.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please fill Customer ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int customerId = Integer.parseInt(id);
            // Search for the customer by ID
            Customer foundCustomer = searchCustomerById(customerId);
            if (foundCustomer != null) {
                // Display the found customer's information in the text area
                txtAreaCustomers.append("Customer ID: " + customerId + "\nName: " + foundCustomer.getFirstName() + " " + foundCustomer.getLastName() +
                        "\nSkiing Level: " + foundCustomer.getSkiingLevel() + "\nContact No: " + foundCustomer.getContact() + 
                        "\nEmail: " + foundCustomer.getEmail() + "\n");
            
            }
            else {
            // Display an error message if the customer is not found
                //txtAreaCustomers.append("Customer not found.");
                JOptionPane.showMessageDialog(null, "Customer not Found!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            
        // Handle invalid input in the text field (non-numeric value)
            JOptionPane.showMessageDialog(null, "Invalid customer ID format. Input Integer.", "Input Error", JOptionPane.ERROR_MESSAGE);

        }
        catch(Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage()); 
        }
        
    }
    
    
    
    // Search customer by ID
    public Customer searchCustomerById(int custId) {
        for (Customer c:customers) {
            if (c.getCustId() == custId){
                return c;
            }
        }
        return null;
    }
    //method not allow to remove customers who are already include in package
    private boolean canRemoveCustomer(Customer customer) {
        for (TravelPackage pkg : packages) {
            if (pkg.getCustomer().equals(customer)) {
                JOptionPane.showMessageDialog(null, "Cannot remove this customer! It is included in a package.", "Removal Error", JOptionPane.ERROR_MESSAGE);
                return false;  // Customer is in a package, cannot remove
                
            }
        }
        return true;  // Customer is not in any package, can remove
    }
    
    //remove customer by ID

    public void removeCustomerbyId(String id) {
        txtAreaCustomers.setText("");
        if (id.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please fill Customer ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int customerId = Integer.parseInt(id);
            Customer customerToRemove = searchCustomerById(customerId);
            if (customerToRemove != null && canRemoveCustomer(customerToRemove)) {
                customers.remove(customerToRemove);
                updateCustomerComboBox();  // Refresh combo box in the travel package tab
                txtAreaCustomers.append("Customer ID: " + customerId + " removed successfully.\n");
            }
            else if(customerToRemove == null){
                JOptionPane.showMessageDialog(null, "Customer not Found!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
             
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid customer ID format. Enter Integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage()); 
        }
    }
    
    
    

    //method to clear customer lists
    private void clearCustomerFields() {
        txtFirstName.setText("");
        txtLastName.setText("");
        txtAddress.setText("");
        txtContact.setText("");
        txtEmail.setText("");
        skiingLevelCmboBox.setSelectedIndex(0);
        txtAreaCustomers.setText("");
        JOptionPane.showMessageDialog(null, "Clear.");
    }
    
    public void displayAccommodationCheckBox(){
        
        listModel.clear();
        
        for (Accommodation accommodation : accommodations){
            if(
                    hotelCheckBox.isSelected() && accommodation.getType().equalsIgnoreCase("Hotel")||
                    hostelCheckBox.isSelected() && accommodation.getType().equalsIgnoreCase("Hostel") ||
                    apartmentCheckBox.isSelected() && accommodation.getType().equalsIgnoreCase("Apartment")||
                    lodgeCheckBox.isSelected() && accommodation.getType().equalsIgnoreCase("Lodge"))
            {
                listModel.addElement(accommodation.toString());
                
            }
                    
        }
    }
    public void displayAllAccommodation(){
        listModel.clear();
        hotelCheckBox.setSelected(false);
        hostelCheckBox.setSelected(false);
        apartmentCheckBox.setSelected(false);
        lodgeCheckBox.setSelected(false);
        for (Accommodation accommodation : accommodations){
            listModel.addElement(accommodation.toString());
        }
    }
    
    public void displayAvailableAccommodation(){
        listModel.clear();
        hotelCheckBox.setSelected(false);
        hostelCheckBox.setSelected(false);
        apartmentCheckBox.setSelected(false);
        lodgeCheckBox.setSelected(false);
     
        for (Accommodation accommodation : accommodations) {
            if (accommodation.isAvailable()) {  // Check if the accommodation is available
                listModel.addElement(accommodation.toString());
            }
        }
        
    }
    
    public void updateImageDisplay(String selectedAccommodation){
        for (Accommodation accommodation : accommodations){
            if(accommodation.toString().equalsIgnoreCase(selectedAccommodation)){
                ImageIcon image = new ImageIcon(accommodation.getImage());
                imageLabel.setIcon(image);
                imageName.setText(accommodation.getName()); 
                break;
            }
        }
        
        
    }
     public void searchAccommodationByID(String searchID) {
         accommodationTextArea.setText("");
        if (searchID.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please fill Accommodation ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
                
            }
        try {
            
            int id = Integer.parseInt(searchID);  // Convert string to integer
            boolean found = false;
            for (Accommodation accommodation : accommodations) {
                if (accommodation.getId() == id) {  // Compare integer IDs
                    accommodationTextArea.setText("ID : " + accommodation.getId() 
                    +"\nType: " + accommodation.getType() + "\nPrice: " + accommodation.getPrice() + "\nAvailability: " + accommodation.getAvailability());
                    found = true;
                    break;
                }
            }
            if (!found) {
                accommodationTextArea.setText("No accommodation found with ID: " + searchID);
                JOptionPane.showMessageDialog(null, "No accommodation found! Please enter again!");
            }
        } catch (NumberFormatException e) {
            accommodationTextArea.setText("Invalid ID format: " + searchID + ". Please enter a valid integer.");
            JOptionPane.showMessageDialog(null, "Invalid Accommodation ID format.Please Eneter Integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            accommodationTextArea.setText("Error occurred while searching: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error during search: " + e);
        }
    }
     
        
     //remove customer by Id
    public void removeAccommodationbyId(String id){
        accommodationTextArea.setText("");
        if (id.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please fill Accommodation ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
 
            try {
                int accId = Integer.parseInt(id);
                boolean accommodationFound = false;
                for (int i = 0; i < accommodations.size(); i++) {
                    Accommodation a = accommodations.get(i);
                    if (a.getId() == accId) {
                        accommodations.remove(a);
                        accommodationTextArea.append("\nAccommodation ID : " + id + " removed successfully!");
                        accommodationFound = true;
                        break;
                    }
                    }
                    if(!accommodationFound){
                        accommodationTextArea.setText("No accommodation found with ID: " + id);
                        JOptionPane.showMessageDialog(null, "No Accommodation found to remove! Enter again!");
                    } 
                
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Invalid Accommodation ID format.Please Eneter Integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
               
                
            } catch(Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage());
                
            }
            
 
        }
    
    
    // Method to handle the creation of a travel package
    private void addPackage() {
        
        packageListArea.setText("");
    // Get input values
        Customer selectedCustomer = (Customer) customerComboBox.getSelectedItem();
        Accommodation selectedAccommodation = (Accommodation) accommodationComboBox.getSelectedItem();
        
        String startDateStr = startDateField.getText();
        String durationStr = durationField.getText();

    // Validate inputs
        if (selectedCustomer == null || selectedAccommodation == null || startDateStr.isEmpty() || durationStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields correctly.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

    // Create and add the package
        try {
            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
            LocalDate startDay = LocalDate.parse(startDateStr); // Parse the startDate string into a LocalDate object
            int durationDays = Integer.parseInt(durationStr); // Convert the duration String to an integer

            // Create and add the package
            TravelPackage newPackage = new TravelPackage(selectedCustomer, selectedAccommodation, startDay, durationDays);
            packages.add(newPackage); 
            selectedAccommodation.setAvailability(false);
            updatePackageCombo();
            newPackage.setCutId(selectedCustomer.getCustId());
            updateAccommodationCombo();
            newPackage.setAccommodationId(selectedAccommodation.getId());
            double totalAccommodationCost = newPackage.getAccommodation().getPrice() * durationDays;
            double totalCost = totalAccommodationCost;
            newPackage.setTotalCost(totalCost);
            newPackage.totalAccommodationCost(newPackage.getAccommodation().getPrice() * durationDays);
            startDateField.setText("");
            durationField.setText("");
            packageListArea.append("Package created: " + "\nPackage ID: " + newPackage.getTravelPackageId() + 
                    "\nAccommodationID: " + newPackage.getAccommodationId() +
                    "\nCustomer: " + selectedCustomer.getCustId() +
                    "\nStarted Date: " + startDay +
                    "\nDuration: " + durationDays + " days \n" +
                    "Total Accommodation Cost: " + totalAccommodationCost + "\n");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Duration must be an integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Please use yyyy-mm-dd.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error creating package: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //Update customer combo after add new customer detail
    private void updateCustomerComboBox() {
        DefaultComboBoxModel<Customer> model = new DefaultComboBoxModel<>();
        for (Customer customer : customers) {
            model.addElement(customer);
        }
        customerComboBox.setModel(model);
    }
    //update travelPackageCombo in liftPass and Lesson Fee Panels
    private void updatePackageCombo() {
        DefaultComboBoxModel<TravelPackage> model = new DefaultComboBoxModel<>();
        for (TravelPackage travel : packages) {
            model.addElement(travel);
        }
        packageComboBox.setModel(model);
        travelPackageComboBox.setModel(model);
    }
    
    //update Accommodationcombo after seleted the accommondation and wen it becomes unavailable
    private void updateAccommodationCombo(){
        DefaultComboBoxModel<Accommodation> model = new DefaultComboBoxModel<>();
        for (Accommodation acc : accommodations) {
            if(acc.isAvailable()){
                model.addElement(acc);
            }
        }
        accommodationComboBox.setModel(model);
    }

    
    
    
    
    public void addLessonFee(){
        
        packageListArea.setText("");
        TravelPackage selectedPackage = (TravelPackage) packageComboBox.getSelectedItem();
        if (selectedPackage == null){
            JOptionPane.showMessageDialog(this, "Please select a package first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            Customer customer = selectedPackage.getCustomer();
            int lessonFee;
            //String skiingLevel = customer.getSkiingLevel();
            switch(customer.getSkiingLevel().toLowerCase()){
                case "beginner":
                    lessonFee = 25;
                    selectedPackage.setLessonFee(lessonFee);
                    break;
                case "intermediate":
                    lessonFee = 20;
                    selectedPackage.setLessonFee(lessonFee);
                    break;
                case "expert":
                    lessonFee = 15;
                    selectedPackage.setLessonFee(lessonFee);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid skiing level: " + customer.getSkiingLevel(), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
            }
            
            Integer selectedLessonCount = (Integer) lessondays.getSelectedItem();
            if (selectedLessonCount == null) {
                JOptionPane.showMessageDialog(null, "No lesson count selected. Please select the number of lessons.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double totalLessonFee = selectedLessonCount * lessonFee;
            double totalCost = selectedPackage.getTotalCost() + totalLessonFee;
            selectedPackage.setTotalLessonFee(totalLessonFee);
            selectedPackage.setLessonCount(selectedLessonCount);
            selectedPackage.setTotalCost(totalCost);
            selectedPackage.setLessonType( customer.getSkiingLevel());
            packageListArea.append("Lesson Fee Add to Package ID: " + selectedPackage.getTravelPackageId());
            packageListArea.append("\nNo of Lessons: " + selectedLessonCount + "\nLesson Type: " + selectedPackage.getLessonType());
            packageListArea.append("\nTotal Lesson Fee: "+ totalLessonFee);
            JOptionPane.showMessageDialog(this, "Lesson added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        

        
    }
    private void addLiftPass() {
        packageListArea.setText("");
        TravelPackage selectedPackage = (TravelPackage) packageComboBox.getSelectedItem();
        Integer selectedDays = (Integer) liftPassTypeComboBox.getSelectedItem();

        if (selectedPackage == null) {
            JOptionPane.showMessageDialog(this, "Please select a package first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (selectedDays == null) {
            JOptionPane.showMessageDialog(this, "Please select the number of days for the lift pass.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double liftPassFee = calculateLiftPassFee(selectedDays);
        String liftPassType;
        if (selectedDays <= 4) {
            liftPassType = "Standard";
        } else if (selectedDays <= 10) {
            liftPassType = "Discount Pass";
        } else {
            liftPassType = "Season";
        }
       
        double totalCost = selectedPackage.getTotalCost() + liftPassFee;
        selectedPackage.setLiftpassCost(liftPassFee);
        selectedPackage.setTotalCost(totalCost);
        selectedPackage.setLiftPassType(liftPassType);
        
        packageListArea.append("Lift pass added to Package ID: " + selectedPackage.getTravelPackageId() +
                               "\nNumber of Days: " + selectedDays +
                               "\nTotal Lift Pass Fee: $" + liftPassFee +
                               "\nLiftPass Type : " + liftPassType + "\n");

        JOptionPane.showMessageDialog(this, "Lift pass added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        
}

    private double calculateLiftPassFee(int days) {
        final double dailyRate = 26.0;
        String liftPassType;
        double totalFee;
        if (days <= 4) {
            liftPassType = "Standard";
            totalFee = days * dailyRate;
        } else if (days <= 10) {
            liftPassType = "Discount Pass";
            totalFee = days * dailyRate * 0.9; // 10% discount for 5 to 10 days
        } else {
            liftPassType = "Season";
            totalFee = 200; // Flat rate for season pass
        }

        return totalFee;
    }


    
    
    
        //list Packages
    private void listPackages() {
        packageListArea.setText("");
        if (packages.isEmpty()) {           
        packageListArea.setText("No Package founded.");
        JOptionPane.showMessageDialog(null, "No Package found.");
        
        }else{
        for (TravelPackage pkg : packages) {
        packageListArea.append("Package Detail\n--------\n"+ "ID: " + pkg.getTravelPackageId() +
                "\nCustomer ID: " + pkg.getCutId() + "\nAccommodation ID: " + pkg.getAccommodationId() +
                "\nStart Date: " + pkg.getStartDate() + "\nDuration: " + pkg.getDuration() +
                "\nLift Pass Type: " + pkg.getLiftPassType() + "\nNumber of Lessons: "+ pkg.getLessonCount() +
                "\nTotal Cost: " + pkg.getTotalCost());
        }
        }
    }

    
//    public TravelPackage findPackage(int packageId) {
//        for (TravelPackage t:packages) {
//            if (t.getTravelPackageId() == packageId){
//                return t;
//            }
//        }
//        return null;
//    }
//    
//    public void searchPackageByID(){
//        packageListArea.setText("");
//        
//        try{
//            int id = Integer.parseInt(packageIdField.getText());
//            TravelPackage foundPackage = findPackage(id);
//            if(foundPackage !=null){
//                packageListArea.append(foundPackage.toString());
//                
//            }else{
//                JOptionPane.showMessageDialog(null, "No Package found!");
//            }
//        }catch(NumberFormatException e){
//            packageListArea.append("Invalid ID!");
//            JOptionPane.showMessageDialog(null, "Invalid ID!");
//            
//            
//        }catch (Exception e){
//            JOptionPane.showMessageDialog(null, "Enter Package ID!");
//        }
//    }

    
    
    
    private void savePackage() {
        packageListArea.setText("");
        try {
          fos = new FileOutputStream("packages.dat");

          oos = new ObjectOutputStream(fos);
          for (TravelPackage t:packages) {
             oos.writeObject(t);
          }
          fos.close();
          oos.close();
            JOptionPane.showMessageDialog(this, "Packages saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Failed to save packages: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    private Accommodation searchAccommodationByID(int id) {
        for (Accommodation a : accommodations) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;  // Return null if no accommodation is found with the given ID
    }

    
    private void readPackage() {
        packageListArea.setText("");
        packages.clear();  // Clear existing packages
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("packages.dat");
            ois = new ObjectInputStream(fis);
            while (true) {  // This loop will run until an EOFException is caught
                try {
                    TravelPackage t = (TravelPackage) ois.readObject();
                    packageListArea.append("Package Detail\n--------\n"+ "ID: " + t.getTravelPackageId() +
                    "\nCustomer ID: " + t.getCutId() + "\nAccommodation ID: " + t.getAccommodationId() +
                    "\nStart Date: " + t.getStartDate() + "\nDuration: " + t.getDuration() +
                    "\nLift Pass Type: " + t.getLiftPassType() + "\nNumber of Lessons: "+ t.getLessonCount() +
                    "\nTotal Cost: " + t.getTotalCost());
                    // Update accommodation availability
                    Accommodation a = searchAccommodationByID(t.getAccommodationId());
                    if (a != null) {
                        a.setAvailability(false);
                        packages.add(t);  // Add package to the list
                        
                    }
                } catch (EOFException eof) {
                    // EOFException is expected when end of file is reached
                    break;
                }
            }
            JOptionPane.showMessageDialog(this, "Packages loaded successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File not found: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Class not found: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (ois != null) ois.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error closing file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
//actionPerformed
    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddCustomer) {
        String fName = txtFirstName.getText();
        String lName = txtLastName.getText();
        String contactNo = txtContact.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();
        String skiingLevel = (String) skiingLevelCmboBox.getSelectedItem();
        // Call the addCustomer method with parameters
        addCustomer(fName, lName, contactNo, email, address, skiingLevel);
        
        }
        
        else if (e.getSource() == btnListCustomers) {
            // Clear the text area before listing customers
            txtAreaCustomers.setText("");
            listCustomers();
        }
        else if(e.getSource() == btnClearCustomers){
            clearCustomerFields();
        }
        else if (e.getSource()==searchButton){
            //txtAreaCustomers.setText("");
            String id =txtcustomerIdField.getText();
            searchCustomerbyID(id);
        }else if (e.getSource() ==removeButton){
            //txtAreaCustomers.setText("");
            String id = txtcustomerIdField.getText();
            removeCustomerbyId(id);
        }else if (e.getSource() instanceof JCheckBox) {
            displayAccommodationCheckBox();
        }else if (e.getSource() == searchAccommodation){
            String accommodationId = txtAccID.getText();
            searchAccommodationByID(accommodationId);
        }else if (e.getSource() == removeAccommodation){
            String accommodationId = txtAccID.getText();
            removeAccommodationbyId( accommodationId);
            
        }
        else if (e.getSource() == btnDisplayAcc) {
            displayAllAccommodation();
        }
        else if (e.getSource() == btnDisplayAvailableAcc){
            displayAvailableAccommodation();
            
        }
        else if (e.getSource() == createPackageButton){
            addPackage();
            
        }else if (e.getSource()==addLessonButton){
            addLessonFee();
        }else if (e.getSource()== lessonFees){
            JOptionPane.showMessageDialog(null, "Skiing Lesson Price \n---Beginner---\n$25 per lesson.\n" +
                    "\n---Intermediate--- \n$20 per lesson.\n" + 
                    "\n---Expert---\n $15 per lesson.", "Lesson Fees", JOptionPane.INFORMATION_MESSAGE );
            
        }else if (e.getSource() == liftPassFeebtn){
            JOptionPane.showMessageDialog(null, "Lift Pass Type\n---Standard---\n(4 days or less): $26 per day\n" +
                    "\n---Discount Pass--- \n(5 to 10 days): 10% discount\n" + 
                    "\n---Season Pass---\n (11 days or more): $200", "LiftPass Types and Rates", JOptionPane.INFORMATION_MESSAGE  );
        }else if (e.getSource() == addLiftPassButton){
            addLiftPass();
        }
        
        else if (e.getSource() == listPackagesButton) {
       // Clear the text area before listing customers
            packageListArea.setText("");
        
            listPackages();
        
        
        }else if (e.getSource() == savePackage){
            savePackage();
        }else if(e.getSource() == readPackage){
            readPackage();
        }
    }

    
}
