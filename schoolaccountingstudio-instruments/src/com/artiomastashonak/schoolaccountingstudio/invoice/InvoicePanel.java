package com.artiomastashonak.schoolaccountingstudio.invoice;

import com.artiomastashonak.schoolaccountingstudio.Button;
import com.artiomastashonak.schoolaccountingstudio.DarkThemeColors;
import com.artiomastashonak.schoolaccountingstudio.Label;
import com.artiomastashonak.schoolaccountingstudio.TextField;
import com.artiomastashonak.schoolaccountingstudio.TextSizes;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.util.ResourceBundle;

public final class InvoicePanel extends JPanel {

    private final ResourceBundle bundle;
    public final InvoiceHandler handler = new InvoiceHandler();

    private final Color mainWindowColor = DarkThemeColors.MAIN_WINDOW_BACKGROUND_COLOR.color;
    private final Color textInputColor = DarkThemeColors.MENU_BAR_BACKGROUND_COLOR.color;
    private final Color buttonColor = DarkThemeColors.BUTTON_BACKGROUND_COLOR.color;
    private final Color textColor = DarkThemeColors.PRIMARY_TEXT_COLOR.color;
    private final Font sectionTitleFont = new Font("K2D", Font.BOLD, TextSizes.SUBSECTION_TITLE_TEXT_SIZE.size);
    private final Font elementTitleFont = new Font("K2D", Font.BOLD, TextSizes.ELEMENT_TITLE_TEXT_SIZE.size);
    private final Font inputFont = new Font("K2D", Font.PLAIN, TextSizes.BUTTON_TEXT_SIZE.size);

    private final Button openSellerButton;
    public final TextField sellerName = new TextField(textInputColor, textColor, inputFont);
    public final TextField sellerAddress = new TextField(textInputColor, textColor, inputFont);
    public final TextField sellerPhone = new TextField(textInputColor, textColor, inputFont);
    public final TextField sellerEmail = new TextField(textInputColor, textColor, inputFont);
    public final TextField sellerRegister = new TextField(textInputColor, textColor, inputFont);
    public final TextField sellerSharedCapital = new TextField(textInputColor, textColor, inputFont);

    private final Button openCustomerButton;
    public final TextField customerName = new TextField(textInputColor, textColor, inputFont);
    public final TextField customerAddress = new TextField(textInputColor, textColor, inputFont);
    public final TextField customerPhone = new TextField(textInputColor, textColor, inputFont);
    public final TextField customerEmail = new TextField(textInputColor, textColor, inputFont);
    public final TextField customerRegister = new TextField(textInputColor, textColor, inputFont);
    public final TextField customerSharedCapital = new TextField(textInputColor, textColor, inputFont);

    private final Button openInvoiceInfoButton;
    public final TextField invoiceNumber = new TextField(textInputColor, textColor, inputFont);
    public final TextField invoiceDate = new TextField(textInputColor, textColor, inputFont);
    public final TextField invoiceDelivery = new TextField(textInputColor, textColor, inputFont);
    public final TextField invoiceTransport = new TextField(textInputColor, textColor, inputFont);
    public final TextField invoicePackaging = new TextField(textInputColor, textColor, inputFont);
    public final TextField invoicePayment = new TextField(textInputColor, textColor, inputFont);
    public final TextField invoiceNonDocumentedCost = new TextField(textInputColor, textColor, inputFont);
    public final TextField invoiceDocumentedCost = new TextField(textInputColor, textColor, inputFont);
    public final TextField invoiceInterests = new TextField(textInputColor, textColor, inputFont);
    public final TextField invoiceDeposit = new TextField(textInputColor, textColor, inputFont);

    private final TextField measureUnit;
    private final TextField quantity;
    private final TextField code;
    private final TextField description;
    private final TextField vat;
    private final TextField unitPrice;
    private final TextField discount1;
    private final TextField discount2;

    private final Button addItemButton;

    public JTable invoiceTable;

    public InvoicePanel(@NotNull ResourceBundle bundle) {
        this.bundle = bundle;

        setBackground(mainWindowColor);
        SpringLayout layout = new SpringLayout();
        setLayout(layout);

        Label welcomeLabel = new Label(bundle.getString("invoiceGenerator"),
                mainWindowColor,
                textColor,
                sectionTitleFont);
        add(welcomeLabel);
        layout.putConstraint(SpringLayout.WEST, welcomeLabel, 450, SpringLayout.WEST, this);

        Label sellerLabel = new Label(bundle.getString("seller"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        add(sellerLabel);
        layout.putConstraint(SpringLayout.NORTH, sellerLabel, 50, SpringLayout.SOUTH, welcomeLabel);
        layout.putConstraint(SpringLayout.WEST, sellerLabel, 200, SpringLayout.WEST, this);

        openSellerButton = new Button(bundle.getString("addSeller"),
                buttonColor,
                textColor,
                inputFont);
        add(openSellerButton);
        layout.putConstraint(SpringLayout.NORTH, openSellerButton, 10, SpringLayout.SOUTH, sellerLabel);
        layout.putConstraint(SpringLayout.WEST, openSellerButton, 0, SpringLayout.WEST, sellerLabel);
        openSellerButton.addActionListener((e) -> showSellerDialog());

        Label customerLabel = new Label(bundle.getString("customer"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        add(customerLabel);
        layout.putConstraint(SpringLayout.NORTH, customerLabel, 50, SpringLayout.SOUTH, welcomeLabel);
        layout.putConstraint(SpringLayout.WEST, customerLabel, 250, SpringLayout.EAST, sellerLabel);

        openCustomerButton = new Button(bundle.getString("addCustomer"),
                buttonColor,
                textColor,
                inputFont);
        add(openCustomerButton);
        layout.putConstraint(SpringLayout.NORTH, openCustomerButton, 10, SpringLayout.SOUTH, customerLabel);
        layout.putConstraint(SpringLayout.EAST, openCustomerButton, 0, SpringLayout.EAST, customerLabel);
        openCustomerButton.addActionListener((e) -> showCustomerDialog());

        Label invoiceInfoLabel = new Label(bundle.getString("invoiceInfo"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        add(invoiceInfoLabel);
        layout.putConstraint(SpringLayout.NORTH, invoiceInfoLabel, 15, SpringLayout.SOUTH, openSellerButton);
        layout.putConstraint(SpringLayout.WEST, invoiceInfoLabel, 0, SpringLayout.WEST, sellerLabel);

        openInvoiceInfoButton = new Button(bundle.getString("open"),
                buttonColor,
                textColor,
                inputFont);
        add(openInvoiceInfoButton);
        layout.putConstraint(SpringLayout.NORTH, openInvoiceInfoButton, 10, SpringLayout.SOUTH, invoiceInfoLabel);
        layout.putConstraint(SpringLayout.WEST, openInvoiceInfoButton, 0, SpringLayout.WEST, invoiceInfoLabel);
        openInvoiceInfoButton.addActionListener((e) -> showInvoiceInfoDialog());

        measureUnit = new TextField(textInputColor,
                textColor,
                inputFont);
        measureUnit.setColumns(6);
        add(measureUnit);
        layout.putConstraint(SpringLayout.NORTH, measureUnit, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
        layout.putConstraint(SpringLayout.WEST, measureUnit, 200, SpringLayout.WEST, this);

        quantity = new TextField(textInputColor,
                textColor,
                inputFont);
        quantity.setColumns(6);
        add(quantity);
        layout.putConstraint(SpringLayout.NORTH, quantity, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
        layout.putConstraint(SpringLayout.WEST, quantity, 25, SpringLayout.EAST, measureUnit);

        code = new TextField(textInputColor,
                textColor,
                inputFont);
        code.setColumns(6);
        add(code);
        layout.putConstraint(SpringLayout.NORTH, code, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
        layout.putConstraint(SpringLayout.WEST, code, 25, SpringLayout.EAST, quantity);

        description = new TextField(textInputColor,
                textColor,
                inputFont);
        description.setColumns(6);
        add(description);
        layout.putConstraint(SpringLayout.NORTH, description, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
        layout.putConstraint(SpringLayout.WEST, description, 25, SpringLayout.EAST, code);

        vat = new TextField(textInputColor,
                textColor,
                inputFont);
        vat.setColumns(6);
        add(vat);
        layout.putConstraint(SpringLayout.NORTH, vat, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
        layout.putConstraint(SpringLayout.WEST, vat, 25, SpringLayout.EAST, description);

        unitPrice = new TextField(textInputColor,
                textColor,
                inputFont);
        unitPrice.setColumns(6);
        add(unitPrice);
        layout.putConstraint(SpringLayout.NORTH, unitPrice, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
        layout.putConstraint(SpringLayout.WEST, unitPrice, 25, SpringLayout.EAST, vat);

        discount1 = new TextField(textInputColor,
                textColor,
                inputFont);
        discount1.setColumns(6);
        add(discount1);
        layout.putConstraint(SpringLayout.NORTH, discount1, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
        layout.putConstraint(SpringLayout.WEST, discount1, 25, SpringLayout.EAST, unitPrice);

        discount2 = new TextField(textInputColor,
                textColor,
                inputFont);
        discount2.setColumns(6);
        add(discount2);
        layout.putConstraint(SpringLayout.NORTH, discount2, 25, SpringLayout.SOUTH, openInvoiceInfoButton);
        layout.putConstraint(SpringLayout.WEST, discount2, 25, SpringLayout.EAST, discount1);

        addItemButton = new Button(bundle.getString("add"),
                buttonColor,
                textColor,
                inputFont);
        add(addItemButton);
        layout.putConstraint(SpringLayout.NORTH, addItemButton, 25, SpringLayout.SOUTH, discount2);
        layout.putConstraint(SpringLayout.EAST, addItemButton, 0, SpringLayout.EAST, discount2);

        DefaultTableModel tableModel = new DefaultTableModel();

        String[] columns = {bundle.getString("measureUnitShort"),
                bundle.getString("quantityShort"),
                bundle.getString("code"),
                bundle.getString("description"),
                bundle.getString("vatPercentage"),
                bundle.getString("unitPrice"),
                bundle.getString("discount1"),
                bundle.getString("discount2")};
        tableModel.setColumnIdentifiers(columns);

        invoiceTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(invoiceTable);
        tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        tableScrollPane.setBorder(null);

        add(tableScrollPane);
        layout.putConstraint(SpringLayout.NORTH, tableScrollPane, 10, SpringLayout.SOUTH, addItemButton);
        layout.putConstraint(SpringLayout.WEST, tableScrollPane, 200, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, tableScrollPane, 0, SpringLayout.EAST, addItemButton);
    }

    private void showSellerDialog() {
        JDialog sellerDialog = new JDialog();
        sellerDialog.setTitle(bundle.getString("seller"));
        sellerDialog.setModal(true);
        sellerDialog.setSize(400, 300);
        sellerDialog.setResizable(false);
        sellerDialog.getContentPane().setBackground(mainWindowColor);
        SpringLayout layout = new SpringLayout();
        sellerDialog.setLayout(layout);

        Label sellerNameLabel = new Label(bundle.getString("name"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        sellerDialog.add(sellerNameLabel);
        layout.putConstraint(SpringLayout.NORTH, sellerNameLabel, 5, SpringLayout.NORTH, sellerDialog);
        layout.putConstraint(SpringLayout.WEST, sellerNameLabel, 5, SpringLayout.WEST, sellerDialog);

        sellerName.setColumns(12);
        sellerDialog.add(sellerName);
        layout.putConstraint(SpringLayout.SOUTH, sellerName, 0, SpringLayout.SOUTH, sellerNameLabel);
        layout.putConstraint(SpringLayout.WEST, sellerName, 5, SpringLayout.EAST, sellerNameLabel);

        Label sellerAddressLabel = new Label(bundle.getString("address"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        sellerDialog.add(sellerAddressLabel);
        layout.putConstraint(SpringLayout.NORTH, sellerAddressLabel, 5, SpringLayout.SOUTH, sellerNameLabel);
        layout.putConstraint(SpringLayout.WEST, sellerAddressLabel, 5, SpringLayout.WEST, sellerDialog);

        sellerAddress.setColumns(12);
        sellerDialog.add(sellerAddress);
        layout.putConstraint(SpringLayout.SOUTH, sellerAddress, 0, SpringLayout.SOUTH, sellerAddressLabel);
        layout.putConstraint(SpringLayout.WEST, sellerAddress, 5, SpringLayout.EAST, sellerAddressLabel);

        Label sellerPhoneLabel = new Label(bundle.getString("phone"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        sellerDialog.add(sellerPhoneLabel);
        layout.putConstraint(SpringLayout.NORTH, sellerPhoneLabel, 5, SpringLayout.SOUTH, sellerAddressLabel);
        layout.putConstraint(SpringLayout.WEST, sellerPhoneLabel, 5, SpringLayout.WEST, sellerDialog);

        sellerPhone.setColumns(12);
        sellerDialog.add(sellerPhone);
        layout.putConstraint(SpringLayout.SOUTH, sellerPhone, 0, SpringLayout.SOUTH, sellerPhoneLabel);
        layout.putConstraint(SpringLayout.WEST, sellerPhone, 5, SpringLayout.EAST, sellerPhoneLabel);

        Label sellerEmailLabel = new Label(bundle.getString("email"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        sellerDialog.add(sellerEmailLabel);
        layout.putConstraint(SpringLayout.NORTH, sellerEmailLabel, 5, SpringLayout.SOUTH, sellerPhoneLabel);
        layout.putConstraint(SpringLayout.WEST, sellerEmailLabel, 5, SpringLayout.WEST, sellerDialog);

        sellerEmail.setColumns(12);
        sellerDialog.add(sellerEmail);
        layout.putConstraint(SpringLayout.SOUTH, sellerEmail, 0, SpringLayout.SOUTH, sellerEmailLabel);
        layout.putConstraint(SpringLayout.WEST, sellerEmail, 5, SpringLayout.EAST, sellerEmailLabel);

        Label sellerRegisterLabel = new Label(bundle.getString("register"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        sellerDialog.add(sellerRegisterLabel);
        layout.putConstraint(SpringLayout.NORTH, sellerRegisterLabel, 5, SpringLayout.SOUTH, sellerEmailLabel);
        layout.putConstraint(SpringLayout.WEST, sellerRegisterLabel, 5, SpringLayout.WEST, sellerDialog);

        sellerRegister.setColumns(12);
        sellerDialog.add(sellerRegister);
        layout.putConstraint(SpringLayout.SOUTH, sellerRegister, 0, SpringLayout.SOUTH, sellerRegisterLabel);
        layout.putConstraint(SpringLayout.WEST, sellerRegister, 5, SpringLayout.EAST, sellerRegisterLabel);

        Label sellerCapitalLabel = new Label(bundle.getString("capital"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        sellerDialog.add(sellerCapitalLabel);
        layout.putConstraint(SpringLayout.NORTH, sellerCapitalLabel, 5, SpringLayout.SOUTH, sellerRegisterLabel);
        layout.putConstraint(SpringLayout.WEST, sellerCapitalLabel, 5, SpringLayout.WEST, sellerDialog);

        sellerSharedCapital.setColumns(12);
        sellerDialog.add(sellerSharedCapital);
        layout.putConstraint(SpringLayout.SOUTH, sellerSharedCapital, 0, SpringLayout.SOUTH, sellerCapitalLabel);
        layout.putConstraint(SpringLayout.WEST, sellerSharedCapital, 5, SpringLayout.EAST, sellerCapitalLabel);

        sellerDialog.show();
    }

    private void showCustomerDialog() {
        JDialog customerDialog = new JDialog();
        customerDialog.setTitle(bundle.getString("seller"));
        customerDialog.setModal(true);
        customerDialog.setSize(400, 300);
        customerDialog.setResizable(false);
        customerDialog.getContentPane().setBackground(mainWindowColor);
        SpringLayout layout = new SpringLayout();
        customerDialog.setLayout(layout);

        Label customerNameLabel = new Label(bundle.getString("name"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        customerDialog.add(customerNameLabel);
        layout.putConstraint(SpringLayout.NORTH, customerNameLabel, 5, SpringLayout.NORTH, customerDialog);
        layout.putConstraint(SpringLayout.WEST, customerNameLabel, 5, SpringLayout.WEST, customerDialog);

        customerName.setColumns(12);
        customerDialog.add(customerName);
        layout.putConstraint(SpringLayout.SOUTH, customerName, 0, SpringLayout.SOUTH, customerNameLabel);
        layout.putConstraint(SpringLayout.WEST, customerName, 5, SpringLayout.EAST, customerNameLabel);

        Label customerAddressLabel = new Label(bundle.getString("address"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        customerDialog.add(customerAddressLabel);
        layout.putConstraint(SpringLayout.NORTH, customerAddressLabel, 5, SpringLayout.SOUTH, customerNameLabel);
        layout.putConstraint(SpringLayout.WEST, customerAddressLabel, 5, SpringLayout.WEST, customerDialog);

        customerAddress.setColumns(12);
        customerDialog.add(customerAddress);
        layout.putConstraint(SpringLayout.SOUTH, customerAddress, 0, SpringLayout.SOUTH, customerAddressLabel);
        layout.putConstraint(SpringLayout.WEST, customerAddress, 5, SpringLayout.EAST, customerAddressLabel);

        Label customerPhoneLabel = new Label(bundle.getString("phone"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        customerDialog.add(customerPhoneLabel);
        layout.putConstraint(SpringLayout.NORTH, customerPhoneLabel, 5, SpringLayout.SOUTH, customerAddressLabel);
        layout.putConstraint(SpringLayout.WEST, customerPhoneLabel, 5, SpringLayout.WEST, customerDialog);

        customerPhone.setColumns(12);
        customerDialog.add(customerPhone);
        layout.putConstraint(SpringLayout.SOUTH, customerPhone, 0, SpringLayout.SOUTH, customerPhoneLabel);
        layout.putConstraint(SpringLayout.WEST, customerPhone, 5, SpringLayout.EAST, customerPhoneLabel);

        Label customerEmailLabel = new Label(bundle.getString("email"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        customerDialog.add(customerEmailLabel);
        layout.putConstraint(SpringLayout.NORTH, customerEmailLabel, 5, SpringLayout.SOUTH, customerPhoneLabel);
        layout.putConstraint(SpringLayout.WEST, customerEmailLabel, 5, SpringLayout.WEST, customerDialog);

        customerEmail.setColumns(12);
        customerDialog.add(customerEmail);
        layout.putConstraint(SpringLayout.SOUTH, customerEmail, 0, SpringLayout.SOUTH, customerEmailLabel);
        layout.putConstraint(SpringLayout.WEST, customerEmail, 5, SpringLayout.EAST, customerEmailLabel);

        Label customerRegisterLabel = new Label(bundle.getString("register"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        customerDialog.add(customerRegisterLabel);
        layout.putConstraint(SpringLayout.NORTH, customerRegisterLabel, 5, SpringLayout.SOUTH, customerEmailLabel);
        layout.putConstraint(SpringLayout.WEST, customerRegisterLabel, 5, SpringLayout.WEST, customerDialog);

        customerRegister.setColumns(12);
        customerDialog.add(customerRegister);
        layout.putConstraint(SpringLayout.SOUTH, customerRegister, 0, SpringLayout.SOUTH, customerRegisterLabel);
        layout.putConstraint(SpringLayout.WEST, customerRegister, 5, SpringLayout.EAST, customerRegisterLabel);

        Label customerCapitalLabel = new Label(bundle.getString("capital"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        customerDialog.add(customerCapitalLabel);
        layout.putConstraint(SpringLayout.NORTH, customerCapitalLabel, 5, SpringLayout.SOUTH, customerRegisterLabel);
        layout.putConstraint(SpringLayout.WEST, customerCapitalLabel, 5, SpringLayout.WEST, customerDialog);

        customerSharedCapital.setColumns(12);
        customerDialog.add(customerSharedCapital);
        layout.putConstraint(SpringLayout.SOUTH, customerSharedCapital, 0, SpringLayout.SOUTH, customerCapitalLabel);
        layout.putConstraint(SpringLayout.WEST, customerSharedCapital, 5, SpringLayout.EAST, customerCapitalLabel);

        customerDialog.show();
    }

    private void showInvoiceInfoDialog() {
        JDialog invoiceDialog = new JDialog();
        invoiceDialog.setTitle(bundle.getString("invoice"));
        invoiceDialog.setModal(true);
        invoiceDialog.setSize(725, 300);
        invoiceDialog.setResizable(false);
        invoiceDialog.getContentPane().setBackground(mainWindowColor);
        SpringLayout layout = new SpringLayout();
        invoiceDialog.setLayout(layout);

        Label invoiceNumberLabel = new Label(bundle.getString("number"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        invoiceDialog.add(invoiceNumberLabel);
        layout.putConstraint(SpringLayout.NORTH, invoiceNumberLabel, 5, SpringLayout.NORTH, invoiceDialog);
        layout.putConstraint(SpringLayout.WEST, invoiceNumberLabel, 5, SpringLayout.WEST, invoiceDialog);

        invoiceNumber.setColumns(12);
        invoiceDialog.add(invoiceNumber);
        layout.putConstraint(SpringLayout.NORTH, invoiceNumber, 5, SpringLayout.SOUTH, invoiceNumberLabel);
        layout.putConstraint(SpringLayout.WEST, invoiceNumber, 5, SpringLayout.WEST, invoiceDialog);

        Label invoiceDateLabel = new Label(bundle.getString("date"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        invoiceDialog.add(invoiceDateLabel);
        layout.putConstraint(SpringLayout.NORTH, invoiceDateLabel, 5, SpringLayout.NORTH, invoiceDialog);
        layout.putConstraint(SpringLayout.WEST, invoiceDateLabel, 5, SpringLayout.EAST, invoiceNumber);

        invoiceDate.setColumns(12);
        invoiceDialog.add(invoiceDate);
        layout.putConstraint(SpringLayout.NORTH, invoiceDate, 5, SpringLayout.SOUTH, invoiceDateLabel);
        layout.putConstraint(SpringLayout.WEST, invoiceDate, 5, SpringLayout.EAST, invoiceNumber);

        Label invoiceDeliveryLabel = new Label(bundle.getString("delivery"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        invoiceDialog.add(invoiceDeliveryLabel);
        layout.putConstraint(SpringLayout.NORTH, invoiceDeliveryLabel, 5, SpringLayout.NORTH, invoiceDialog);
        layout.putConstraint(SpringLayout.WEST, invoiceDeliveryLabel, 5, SpringLayout.EAST, invoiceDate);

        invoiceDelivery.setColumns(12);
        invoiceDialog.add(invoiceDelivery);
        layout.putConstraint(SpringLayout.NORTH, invoiceDelivery, 5, SpringLayout.SOUTH, invoiceDeliveryLabel);
        layout.putConstraint(SpringLayout.WEST, invoiceDelivery, 5, SpringLayout.EAST, invoiceDate);

        Label invoiceTransportLabel = new Label(bundle.getString("transport"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        invoiceDialog.add(invoiceTransportLabel);
        layout.putConstraint(SpringLayout.NORTH, invoiceTransportLabel, 5, SpringLayout.NORTH, invoiceDialog);
        layout.putConstraint(SpringLayout.WEST, invoiceTransportLabel, 5, SpringLayout.EAST, invoiceDelivery);

        invoiceTransport.setColumns(12);
        invoiceDialog.add(invoiceTransport);
        layout.putConstraint(SpringLayout.NORTH, invoiceTransport, 5, SpringLayout.SOUTH, invoiceTransportLabel);
        layout.putConstraint(SpringLayout.WEST, invoiceTransport, 5, SpringLayout.EAST, invoiceDelivery);

        Label invoicePackagingLabel = new Label(bundle.getString("packaging"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        invoiceDialog.add(invoicePackagingLabel);
        layout.putConstraint(SpringLayout.NORTH, invoicePackagingLabel, 5, SpringLayout.SOUTH, invoiceNumber);
        layout.putConstraint(SpringLayout.WEST, invoicePackagingLabel, 5, SpringLayout.WEST, invoiceDialog);

        invoicePackaging.setColumns(12);
        invoiceDialog.add(invoicePackaging);
        layout.putConstraint(SpringLayout.NORTH, invoicePackaging, 5, SpringLayout.SOUTH, invoicePackagingLabel);
        layout.putConstraint(SpringLayout.WEST, invoicePackaging, 5, SpringLayout.WEST, invoiceDialog);

        Label invoicePaymentLabel = new Label(bundle.getString("payment"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        invoiceDialog.add(invoicePaymentLabel);
        layout.putConstraint(SpringLayout.NORTH, invoicePaymentLabel, 5, SpringLayout.SOUTH, invoiceDate);
        layout.putConstraint(SpringLayout.WEST, invoicePaymentLabel, 5, SpringLayout.EAST, invoicePackaging);

        invoicePayment.setColumns(12);
        invoiceDialog.add(invoicePayment);
        layout.putConstraint(SpringLayout.NORTH, invoicePayment, 5, SpringLayout.SOUTH, invoicePaymentLabel);
        layout.putConstraint(SpringLayout.WEST, invoicePayment, 5, SpringLayout.EAST, invoicePackaging);

        Label invoiceNonDocumentedCostLabel = new Label(bundle.getString("nonDocumentedCost"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        invoiceDialog.add(invoiceNonDocumentedCostLabel);
        layout.putConstraint(SpringLayout.NORTH, invoiceNonDocumentedCostLabel, 5, SpringLayout.SOUTH, invoiceTransport);
        layout.putConstraint(SpringLayout.WEST, invoiceNonDocumentedCostLabel, 5, SpringLayout.EAST, invoicePayment);

        invoiceNonDocumentedCost.setColumns(12);
        invoiceDialog.add(invoiceNonDocumentedCost);
        layout.putConstraint(SpringLayout.NORTH, invoiceNonDocumentedCost, 5, SpringLayout.SOUTH, invoiceNonDocumentedCostLabel);
        layout.putConstraint(SpringLayout.WEST, invoiceNonDocumentedCost, 5, SpringLayout.EAST, invoicePayment);

        Label invoiceDocumentedCostLabel = new Label(bundle.getString("documentedCost"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        invoiceDialog.add(invoiceDocumentedCostLabel);
        layout.putConstraint(SpringLayout.NORTH, invoiceDocumentedCostLabel, 5, SpringLayout.SOUTH, invoiceTransport);
        layout.putConstraint(SpringLayout.WEST, invoiceDocumentedCostLabel, 5, SpringLayout.EAST, invoiceNonDocumentedCost);

        invoiceDocumentedCost.setColumns(12);
        invoiceDialog.add(invoiceDocumentedCost);
        layout.putConstraint(SpringLayout.NORTH, invoiceDocumentedCost, 5, SpringLayout.SOUTH, invoiceDocumentedCostLabel);
        layout.putConstraint(SpringLayout.WEST, invoiceDocumentedCost, 5, SpringLayout.EAST, invoiceNonDocumentedCost);

        Label invoiceInterestLabel = new Label(bundle.getString("interests"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        invoiceDialog.add(invoiceInterestLabel);
        layout.putConstraint(SpringLayout.NORTH, invoiceInterestLabel, 5, SpringLayout.SOUTH, invoicePackaging);
        layout.putConstraint(SpringLayout.WEST, invoiceInterestLabel, 5, SpringLayout.WEST, invoiceDialog);

        invoiceInterests.setColumns(12);
        invoiceDialog.add(invoiceInterests);
        layout.putConstraint(SpringLayout.NORTH, invoiceInterests, 5, SpringLayout.SOUTH, invoiceInterestLabel);
        layout.putConstraint(SpringLayout.WEST, invoiceInterestLabel, 5, SpringLayout.WEST, invoiceDialog);

        Label invoiceDepositLabel = new Label(bundle.getString("deposit"),
                mainWindowColor,
                textColor,
                elementTitleFont);
        invoiceDialog.add(invoiceDepositLabel);
        layout.putConstraint(SpringLayout.NORTH, invoiceDepositLabel, 5, SpringLayout.SOUTH, invoicePayment);
        layout.putConstraint(SpringLayout.WEST, invoiceDepositLabel, 5, SpringLayout.EAST, invoiceInterests);

        invoiceDeposit.setColumns(12);
        invoiceDialog.add(invoiceDeposit);
        layout.putConstraint(SpringLayout.NORTH, invoiceDeposit, 5, SpringLayout.SOUTH, invoiceDepositLabel);
        layout.putConstraint(SpringLayout.WEST, invoiceDeposit, 5, SpringLayout.EAST, invoiceInterests);

        invoiceDialog.show();
    }
}