import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class CookBook extends JFrame implements ActionListener, ListSelectionListener, WindowListener

{
    public final String RECIPEFILE = "src\\Recipe.csv";
    //Standard GUI field

    //ArrayList- resizable array. Elements can be added and removed after the compiling.
    //This calls the recipe list.
    private ArrayList <Recipe> mRecipe;
    private DefaultListModel<String> mRecipeNames;
//    private DefaultListModel<String>mIngredients;
    private String mRName1;
    private String mIName1;
    private String mDescription1;
    private String mUnit1;
    private String mAmount1;

    //Member GUI field
    private JLabel RecipeName;
    private JLabel RecipeMeasurement;
    private JLabel RecipeDescription;
    private JLabel RecipeUnit;
    private JLabel RecipeIngredientName;
    private JLabel Recipe;
    private JLabel Ingredient;
    private JLabel RInfo;
    private JLabel RIngredients;
    private JLabel RDescription;
    private JLabel IInfo;
    private JLabel IAmount;
    private JLabel IUnit;
    private JLabel IDescription;
    private JFrame window;
    private JPanel panel;
    private JPanel recipes;
    private JPanel buttons;
    private JButton enter;
    private JButton edit;
    private JButton delete;
    //JPanel editButton;
    //JPanel deleteButton;
    private JPanel information;
    private JPanel ingredientInformation;
    private JTextField text;
    private JTextField text2;
    private JTextField text3;
    private JTextField text4;
    private JTextField text5;
    private JList <String> listnames;
    private JList <String> ingredientInfo;
    private JSplitPane splitter;
    private JSplitPane ingredientSplitter;

    public static void main(String[] args)
    {
       // EventQueue.invokeLater(
                //new Runnable() {
                    //@Override
                   // public void run() {
                        //portrays a new GUI to the screen
        new CookBook();



    }
    //GUI
    public CookBook() {


        //questions
        //---------
        //Project due Decmeber 1
        //how to create a box within the window/frame to store user info in a GridLayout?
        //how long should our presentations be?
        //how to call Recipe class so it operates in CookBook
        //how to display the recipes properly on the JFrame once user enters data

        //object created to make a list to store user input.

        //member fields
        mRecipe = new ArrayList<>();
        //
        mRecipeNames = new DefaultListModel<>();
//        mIngredients = new DefaultListModel<>();

//        loadRecipes(RECIPEFILE);

        initCookBook();
    }
        private void initCookBook()
        {

        mRName1 = new String();
        mIName1 = new String();
        mDescription1 = new String();
        //creates the window for programmer to create buttons, panels, etc.
       window = new JFrame();
       window.setPreferredSize(new Dimension(500,350));

       //window.setLayout(new GridLayout(3,1));

       //creates a panel(block) inside of the frame/window.
       panel = new JPanel();
       recipes = new JPanel();
       buttons = new JPanel();
       //editButton = new JPanel();
       //deleteButton = new JPanel();
       information = new JPanel();
       ingredientInformation = new JPanel();
       //creates a textbox inside the frame/window.
       text = new JTextField();
       text2 = new JTextField();
       text3 = new JTextField();
       text4 = new JTextField();
       text5 = new JTextField();
       //sets width and height of textbox(change dimensions later).
       text.setPreferredSize(new Dimension(20,40));
       text2.setPreferredSize(new Dimension(20,40));
       text3.setPreferredSize(new Dimension(20,40));
       text4.setPreferredSize(new Dimension(20,40));
       text5.setPreferredSize(new Dimension(20,40));
       //portrays textbox on frame/window.

       //creates a new button in the program.
       enter = new JButton("Enter");
       edit = new JButton ("Edit");
       delete = new JButton ("Delete");
       //button for user to click
       enter.addActionListener( this);
       edit.addActionListener(this);
       delete.addActionListener(this);
       //JLabel. Outputs a specific set of text programmer created.
       RecipeName = new JLabel("Recipe Name: ");
       RecipeIngredientName = new JLabel("Ingredient(s) Name(s): ");
       RecipeMeasurement = new JLabel("Amount: ");
       RecipeUnit = new JLabel("Unit: ");
       RecipeDescription = new JLabel("Description: ");
       Recipe = new JLabel("Recipes: ");
       Ingredient = new JLabel("Ingredients: ");

       RInfo = new JLabel("Name: ");
       RIngredients = new JLabel("\nIngredient(s) Name(s): ");
       RDescription = new JLabel("\nDescription: ");
       IInfo = new JLabel("Ingredient Name: ");
       IAmount = new JLabel("Amount: ");
       IUnit = new JLabel("Unit: ");
       IDescription = new JLabel("Description: ");


       //creates a list
        listnames = new JList();
       listnames.setVisibleRowCount(3);
       listnames.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       //JList components
        listnames = new JList<String>(mRecipeNames);
        listnames.addListSelectionListener(this);
//        ingredientInfo = new JList();
//        ingredientInfo.setVisibleRowCount(3);
//        ingredientInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        //components
//            ingredientInfo = new JList<String>(mIngredients);
//            ingredientInfo.addListSelectionListener(this);

       //centers the panel on the frame/window
       window.add(panel,BorderLayout.NORTH);
       window.add(buttons, BorderLayout.SOUTH);
       //window.add(editButton,BorderLayout.WEST);
      // window.add(deleteButton,BorderLayout.EAST);
       window.add(recipes, BorderLayout.WEST);
       window.add(information, BorderLayout.EAST);
//       window.add(ingredientInformation,BorderLayout.EAST);
       window.add(new JScrollPane(listnames));
//       window.add(new JScrollPane(ingredientInfo));
        //creates a split panel effect

        splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listnames, information);
        information.setLayout(new GridLayout(0,2));
        splitter.setDividerLocation(150);
        window.add(splitter,BorderLayout.CENTER);
//        ingredientSplitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,ingredientInfo,ingredientInformation);
//            ingredientInformation.setLayout(new GridLayout(0,3));
//            ingredientSplitter.setDividerLocation(300);
//            window.add(ingredientSplitter,BorderLayout.AFTER_LAST_LINE);

       //gives user an exit option
       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //sets title of your program
       window.setTitle("Cookbook");
       //sets sizes
       window.pack();
       //makes frame/window visible on screen
       window.setVisible(true);
        //creates a border around the panel.Sets the sizes of the panel and border(change dimensions later).
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        recipes.setBorder(BorderFactory.createEmptyBorder(45,45,25,45));
        //creates a visual layout on the window to as many rows and columns programmer makes.
        panel.setLayout(new GridLayout(0,2));
        buttons.setLayout(new GridLayout(0, 3));
        recipes.setLayout(new GridLayout(1,1));
        //editButton.setLayout(new GridLayout(0,1));
        //deleteButton.setLayout(new GridLayout(1,2));



        //adds the specific set of text programmer created in JLabel to be visible on the frame/window.
        panel.add(RecipeName);
        panel.add(text);
        panel.add(RecipeIngredientName);
        panel.add(text4);
        panel.add(RecipeMeasurement);
        panel.add(text2);
        panel.add(RecipeUnit);
        panel.add(text5);
        panel.add(RecipeDescription);
        panel.add(text3);
        //adds the button to be visible on the frame/window.
        buttons.add(enter);
        //editButton.add(edit);
        //deleteButton.add(delete);
        buttons.add(edit);
        buttons.add(delete);
        information.add(RIngredients);
        information.add(RInfo);
        information.add(IAmount);
        information.add(RDescription);
        information.add(IUnit);
//        ingredientInfo.add(IInfo);
//        ingredientInfo.add(IAmount);
//        ingredientInfo.add(IUnit);
//        ingredientInfo.add(IDescription);
        recipes.add(Recipe);
        recipes.setVisible(true);

    }




        //create JFrame that allows user to click on whichever recipe they created
        //user should be able to edit their recipe however they like
        // layout should look as a collection of something
        //call recipe
        //decide on colors of JFrame
        //user should be able to save and load their recipe the moment the program runs



            @Override
            public void actionPerformed(ActionEvent e) {
                //sets JLabel to a different set of text.
                //RecipeName.setText("Recipe Name: ");
                //RecipeMeasurement.setText("Measurement: ");
                //RecipeDescription.setText("Description: ");
                //Recipe.setText("Recipes: ");
                //RInfo.setText("Name: " +(String.valueOf(text.getText())));
                //RIngredients.setText("Ingredients: " +(String.valueOf(text2.getText())));
                //RDescription.setText("Description: "+ (String.valueOf(text3.getText())));
                // ???

                String RName = mRName1;
               String IName = mIName1;
               String Description = mDescription1;
               String Unit = mUnit1;
               String Amount = mAmount1;
                Recipe recipe = new Recipe(RName, IName, Description,Unit,Amount);
                recipe.setRName(text.getText());
               recipe.setIName(text4.getText());
               recipe.setDescription(text3.getText());
               recipe.setUnit(text5.getText());
               recipe.setAmount(text2.getText());
                mRecipe.add(recipe);
                String invalidInput = "";
                invalidInput = text.getText();
                String invalidInput2 = "";
                invalidInput2 = text2.getText();
                String invalidInput3 = "";
                invalidInput3 = text3.getText();
                String invalidInput4 = "";
                invalidInput4 = text4.getText();
                String invalidInput5 = "";
                invalidInput5 = text5.getText();
                if (invalidInput == null || invalidInput.isEmpty())
                {
                   JOptionPane.showMessageDialog(this, "ERROR! MUST INPUT A NAME!",
                           "Input Error",JOptionPane.ERROR_MESSAGE);
                   return;
                }
                if (invalidInput2 == null || invalidInput2.isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "ERROR! MUST INPUT THE AMOUNT OF YOUR INGREDIENT(S)!",
                            "Input Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (invalidInput3 == null || invalidInput3.isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "ERROR! MUST INPUT A DESCRIPTION! " +
                                    "THE PEOPLE NEED TO KNOW JUST WHAT YOU'RE FEEDING THEM RIGHT?",
                            "Input Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (invalidInput4 == null || invalidInput4.isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "ERROR! MUST INPUT AN INGREDIENT(S) NAME(S)! " +
                                    "THE PEOPLE NEED TO KNOW JUST WHAT YOU'RE FEEDING THEM RIGHT?",
                            "Input Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (invalidInput5 == null || invalidInput5.isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "ERROR! MUST INPUT YOUR UNITS!" +
                                    "(Cups, Tablespoons, etc.)",
                            "Input Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (e.getSource() == enter){
                    mRecipeNames.addElement(recipe.getRName());
                    listnames.setSelectedIndex(mRecipeNames.getSize() - 1);

                }
                else if (e.getSource() == delete){
                    int idx = listnames.getSelectedIndex();
                    mRecipeNames.removeElementAt(idx);
                    RInfo.setText("Name: ");
                    RIngredients.setText("Ingredients: ");
                    RDescription.setText("Description: ");
                    IAmount.setText("Amount(s): ");
                    IUnit.setText("Unit(s): ");

                }
                else if (e.getSource()== edit){
                    int idx = listnames.getSelectedIndex();
                    mRecipeNames.setElementAt(text.getText(),idx);
                    RInfo.setText("Name: "+text.getText());
                    RIngredients.setText("Ingredients: "+text4.getText());
                    RDescription.setText("Description: "+text3.getText());
                    IAmount.setText("Amount(s): "+text2.getText());
                    IUnit.setText("Unit(s): "+text5.getText());

                }



            }
        //ActionListener editButton = new ActionListener() {
        //override. Performs the actions from the buttons created.
       // public void actionPerformed (ActionEvent e)
       // {



        //}
   // };
    //ActionListener deleteButton = new ActionListener() {

          //  @Override
           // public void actionPerformed(ActionEvent e) {

          //  }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        //
        String SelectedRecipe = (String)listnames.getSelectedValue();
        RInfo.setText("Name: " + SelectedRecipe);
//        String ingredients = text4.getText();
//        String name = text.getText();
//        String amount = text2.getText();
//        String description = text3.getText();
//        String unit = text5.getText();
//        Recipe recIn = new Recipe (ingredients, name, amount, description, unit);
//        recIn.setRName(name);
//        recIn.setAmount(amount);
//        recIn.setDescription(description);
//        recIn.setUnit(unit);
//        recIn.setIName(ingredients);
//        mRecipe.add(recIn);
        RIngredients.setText("Ingredients: " + text4.getText());
        RDescription.setText("Description: " + text3.getText());
        IAmount.setText("Amount(s): " +text2.getText());
        IUnit.setText("Unit(s): "+ text5.getText());
        int index = listnames.getSelectedIndex();
        if (e.getValueIsAdjusting())
            return;
        if (index < 0 || index >= mRecipe.size())
            return;

        listnames.ensureIndexIsVisible(index);
        //
        Recipe recipe = mRecipe.get(index);
        displayRecipe(recipe);

    }
    //activates displayRecipe. Sets textfields to this.
    private void displayRecipe(Recipe recipe) {
    text.setText(recipe.getRName());
    text4.setText(recipe.getIName());
    text3.setText(recipe.getDescription());
    text2.setText(recipe.getAmount());
    text5.setText(recipe.getUnit());
    }

    private void loadRecipes(String fileRecipe){
        File file = new File(fileRecipe);
        Scanner reader=null;
        try {
            reader = new Scanner(file);
            String header = reader.nextLine();
            if(header == null || header.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "ERROR! UNABLE TO LOAD THE DATABASE " +
                                "NUMBER OF RECIPES", "Loading Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            //(this abou this)int numRecipes = Integer.valueOf(addAsAString);

            //for (int i = 0; i < numRecipes; i++) {
                String input = reader.nextLine();
                //checks the values that were input. Separates them by a comma.
                StringTokenizer values = new StringTokenizer(input, ",");
                String name = values.nextToken();
                String ingredients = values.nextToken();
                String description = values.nextToken();
                String unit = values.nextToken();
                String amount = values.nextToken();

                Recipe rcp = new Recipe(name,ingredients,description,unit,amount);
                rcp.setRName(name);
                rcp.setIName(ingredients);
                rcp.setDescription(description);
                rcp.setUnit(unit);
                rcp.setAmount(amount);
                mRecipe.add(rcp);
                mRecipeNames.addElement(name);
            //}
            reader.close();
        }
        catch(Exception load)
        {
            JOptionPane.showMessageDialog(this, "ERROR! UNABLE TO LOAD", "Loading Error",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println(load);
        }
        finally
        {
            reader.close();
        }



}

    @Override
    public void windowOpened(WindowEvent e) {

    }
//saves data
    @Override
    public void windowClosing(WindowEvent e) {
        File recipeFile = new File(RECIPEFILE);
        //reads user input and writes into a file
        FileWriter saveWriter;
        try {
            //append true basically overwrites a file in csv
            saveWriter = new FileWriter(recipeFile);
            //makes sure characters,strings, arrays,etc. efficiently written for file
            //BufferedWriter sW = new BufferedWriter(saveWriter);
            //gives access to syntax ex. System.out
            //PrintWriter psW = new PrintWriter(saveWriter);
            //psW.println(mRecipe);
            //makes sure data is written to the file
            //psW.flush();
            //psW.close();
            //writes everything in the ArrayList out
            saveWriter.write(String.valueOf(mRecipe.size()));
            saveWriter.write("\n");
            for (int i = 0; i < mRecipe.size(); i++) {
                Recipe rcp = mRecipe.get(i);
                saveWriter.write(rcp.getRName());
               saveWriter.write(",");
//                saveWriter.write(rcp.getIName());
                saveWriter.write(",");
//                saveWriter.write(rcp.getDescription());
                saveWriter.write("\n");
            }
            saveWriter.close();
        } catch (Exception save) {
            JOptionPane.showMessageDialog(this, "ERROR! UNABLE TO SAVE", "Saving Error",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println(save);
        }
    }
    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }


}
