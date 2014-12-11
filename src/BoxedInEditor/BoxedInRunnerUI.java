/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BoxedInRunner;

import BoxedInEditor.ImageUtility;
import BoxedInEditor.Level;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author tmb5577
 */
public class BoxedInRunnerUI extends javax.swing.JFrame {
    private BoxedInRunner runner;
    private boolean paused = false;
    private Graphics levelGraphics;
   
    public BoxedInRunnerUI(BoxedInRunner bir) {
        runner = bir;
        initComponents();
        levelGraphics = levelPanel.getGraphics();       // set the graphics object in the ImageUtility class
        KeyControl listener = new KeyControl();
	addKeyListener(listener);
        setFocusable(true);     // make this jFrame focusable, so the user can have their key pressed go to the listener
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        runner.drawLevel(levelGraphics);
    }
    
    public void refreshVariables(){
        // if there is a current level opened, update all the variables needed to draw the level
        if(runner.levelIsOpen()){
            int gridSpacing;
            int numberOfBlocks = runner.getLevelWidth();
            int width = levelPanel.getWidth();
            int height = levelPanel.getHeight();
            if(width < height){
                gridSpacing = width / numberOfBlocks;}  // divide display panel in to 20 x 20 grid
            else{
                gridSpacing = height / numberOfBlocks;}  // divide display panel in to 20 x 20 grid
            Level.boxPixelHeight = gridSpacing; // reset static variables in Level
            Level.boxPixelWidth = gridSpacing;
            ImageUtility.scaleContent(gridSpacing);        // ***** this causes occasionaly NullPoitnerExceptions on startup and is the cause of the buggy drawing after resize ***
        }
    }
    
    private void hideMenuToolbar(){
        menuPanel.setVisible(false);
        this.setSize(new Dimension(this.getWidth() - 150, this.getHeight()));
    }
    
    private void showMenuToolbar(){
        menuPanel.setVisible(true);
        this.setSize(new Dimension(this.getWidth() + 150, this.getHeight()));
    }
    
    private void quitRunner(){
        // other things to check if the game has been saved?????
        System.exit(0); // quit the runner program
    }
    
    private class KeyControl implements KeyListener {
    @Override   
    public void keyPressed(KeyEvent e) {
        if(!paused && runner.levelIsOpen()){    // if the game is not paused
            if(e.getKeyCode() == KeyEvent.VK_UP) {       // if up key
                if(runner.processMove(Level.MOVE_UP)){
                    runner.movePlayer(Level.MOVE_UP);
                    repaint();
                }
            }else if(e.getKeyCode() == KeyEvent.VK_DOWN) {   // if down key
                if(runner.processMove(Level.MOVE_DOWN)){
                    runner.movePlayer(Level.MOVE_DOWN);
                    repaint();
                }
            }else if(e.getKeyCode() == KeyEvent.VK_LEFT) {   // if left key
                if(runner.processMove(Level.MOVE_LEFT)){
                    runner.movePlayer(Level.MOVE_LEFT);
                    repaint();
                }
            }else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {  // if right key
                if(runner.processMove(Level.MOVE_RIGHT)){
                    runner.movePlayer(Level.MOVE_RIGHT);
                    repaint();
                }
            }
        }
    }

        @Override
        public void keyTyped(KeyEvent e) {
            // do nothing
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // do nothing
        }
    
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        levelPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        openGameButton = new javax.swing.JButton();
        restartButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileDropdown = new javax.swing.JMenu();
        fileMenuOpen = new javax.swing.JMenuItem();
        fileMenuSave = new javax.swing.JMenuItem();
        fileMenuRestart = new javax.swing.JMenuItem();
        fileMenuExit = new javax.swing.JMenuItem();
        editDropdown = new javax.swing.JMenu();
        viewDropdown = new javax.swing.JMenu();
        menuToolbarCheckbox = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 600));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        levelPanel.setBackground(new java.awt.Color(204, 204, 204));
        levelPanel.setForeground(new java.awt.Color(102, 255, 102));
        levelPanel.setPreferredSize(new java.awt.Dimension(600, 300));

        javax.swing.GroupLayout levelPanelLayout = new javax.swing.GroupLayout(levelPanel);
        levelPanel.setLayout(levelPanelLayout);
        levelPanelLayout.setHorizontalGroup(
            levelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        levelPanelLayout.setVerticalGroup(
            levelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        getContentPane().add(levelPanel);

        menuPanel.setBackground(new java.awt.Color(153, 204, 255));
        menuPanel.setMaximumSize(new java.awt.Dimension(150, 32767));
        menuPanel.setMinimumSize(new java.awt.Dimension(150, 0));
        menuPanel.setPreferredSize(new java.awt.Dimension(150, 300));

        openGameButton.setText("Open Game");
        openGameButton.setFocusable(false);
        openGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openGameButtonActionPerformed(evt);
            }
        });

        restartButton.setText("Restart Level");
        restartButton.setFocusable(false);
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });

        pauseButton.setText("Pause Game");
        pauseButton.setFocusable(false);
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Save Game");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(openGameButton)
                    .addComponent(restartButton)
                    .addComponent(pauseButton)
                    .addComponent(jButton1))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(openGameButton)
                .addGap(18, 18, 18)
                .addComponent(pauseButton)
                .addGap(18, 18, 18)
                .addComponent(restartButton)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        getContentPane().add(menuPanel);

        fileDropdown.setText("File");

        fileMenuOpen.setText("Open Game");
        fileMenuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuOpenActionPerformed(evt);
            }
        });
        fileDropdown.add(fileMenuOpen);

        fileMenuSave.setText("Save Game");
        fileMenuSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuSaveActionPerformed(evt);
            }
        });
        fileDropdown.add(fileMenuSave);

        fileMenuRestart.setText("Restart Level");
        fileMenuRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuRestartActionPerformed(evt);
            }
        });
        fileDropdown.add(fileMenuRestart);

        fileMenuExit.setText("Exit");
        fileMenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuExitActionPerformed(evt);
            }
        });
        fileDropdown.add(fileMenuExit);

        jMenuBar1.add(fileDropdown);

        editDropdown.setText("Edit");
        jMenuBar1.add(editDropdown);

        viewDropdown.setText("View");

        menuToolbarCheckbox.setSelected(true);
        menuToolbarCheckbox.setText("Menu Toolbar");
        menuToolbarCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuToolbarCheckboxActionPerformed(evt);
            }
        });
        viewDropdown.add(menuToolbarCheckbox);

        jMenuBar1.add(viewDropdown);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>

    private void menuToolbarCheckboxActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // menuToolbar checkbox in view menu clicked
        if(menuToolbarCheckbox.isSelected()){
            showMenuToolbar();
        }else{
            hideMenuToolbar();
        }
    }                                                   

    private void openGameButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               

            // menuToolbar open level button pressed
        runner.openGame();
        repaint();

    }                                              

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // restartLevel button pressed
        runner.restartLevel();
        repaint();
    }                                             

    private void formComponentResized(java.awt.event.ComponentEvent evt) {                                      
        // window is resized
        refreshVariables();
        runner.drawLevel(levelGraphics);
    }                                     

    private void formMouseClicked(java.awt.event.MouseEvent evt) {                                  
        // TODO add your handling code here:
        //refreshVariables();
        runner.drawLevel(levelGraphics);
    }                                 

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // pause button pressed
        if(pauseButton.isSelected()){    // the button is now depressed
            paused = true;      // enable pause
        }else{  // the button is now unpressed
            paused = false;     // disable pause
        }
    }                                           

    private void fileMenuExitActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // file menu exit button
        quitRunner();
    }                                            

    private void fileMenuRestartActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // file menu restart level
        runner.restartLevel();
    }                                               

    private void fileMenuSaveActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // file menu save game button
        runner.saveGame();
    }                                            

    private void fileMenuOpenActionPerformed(java.awt.event.ActionEvent evt) {                                             

            // file menu open game button
            runner.loadGame();

    }                                            

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        runner.saveGame();
    }                                        


    // Variables declaration - do not modify
    private javax.swing.JMenu editDropdown;
    private javax.swing.JMenu fileDropdown;
    private javax.swing.JMenuItem fileMenuExit;
    private javax.swing.JMenuItem fileMenuOpen;
    private javax.swing.JMenuItem fileMenuRestart;
    private javax.swing.JMenuItem fileMenuSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel levelPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JRadioButtonMenuItem menuToolbarCheckbox;
    private javax.swing.JButton openGameButton;
    private javax.swing.JToggleButton pauseButton;
    private javax.swing.JButton restartButton;
    private javax.swing.JMenu viewDropdown;
    // End of variables declaration
}
