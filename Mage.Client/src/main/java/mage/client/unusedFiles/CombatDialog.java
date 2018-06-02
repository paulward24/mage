

/*
 * CombatDialog.java
 *
 * Created on Feb 10, 2010, 3:35:02 PM
 */

//package mage.client.dialog;
package mage.client.unusedFiles;

import mage.client.cards.BigCard;
import mage.view.CombatGroupView;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.UUID;
import mage.client.dialog.MageDialog;
import org.apache.log4j.Logger;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class CombatDialog extends MageDialog {

    private static final Logger logger = Logger.getLogger(CombatDialog.class);

    private UUID gameId;
    private BigCard bigCard;
    private int lastX = 500;
    private int lastY = 300;

    /** Creates new form CombatDialog */
    public CombatDialog() {

        JPanel contentPane = new JPanel() {
            private static final long serialVersionUID = -8283955788355547309L;
            public void paintComponent(Graphics g) {
                g.setColor(new Color(50, 50, 50, 100));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        setContentPane(contentPane);

        initComponents();
        this.setModal(false);

        combatArea.setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        getRootPane().setOpaque(false);

        //setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
    }

    public void init(UUID gameId, BigCard bigCard) {
        this.gameId = gameId;
        this.bigCard = bigCard;
    }

    public void showDialog(List<CombatGroupView> combat) {
        combatArea.removeAll();
        for (CombatGroupView group: combat) {
            CombatGroup combatGroup = new CombatGroup();
            combatGroup.init(gameId, bigCard);
            combatGroup.update(group);
            combatGroup.setVisible(true);
            combatArea.add(combatGroup);
            combatGroup.revalidate();
        }
        try {
            this.setSelected(true);
        } catch (PropertyVetoException ex) {
            logger.error(null, ex);
        }
        pack();
        this.revalidate();
        this.repaint();
        if (!this.isVisible())  {
            this.setVisible(true);
            this.setLocation(lastX, lastY);
        }
    }

    @Override
    public void hideDialog() {
        this.lastX = this.getX();
        this.lastY = this.getY();
        super.hideDialog();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        combatArea = new javax.swing.JPanel();

        setResizable(true);
        setTitle("Combat");
        setNormalBounds(new java.awt.Rectangle(400, 200, 410, 307));
        setVisible(true);
        getContentPane().setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(combatArea);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel combatArea;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
