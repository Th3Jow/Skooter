package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenhador;
import Auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;

public abstract class Elemento implements Serializable {

    protected ImageIcon iImage;
    protected Posicao pPosicao;
    protected boolean bTransponivel; /* Pode passar por cima? */
    protected boolean bMortal; /* Se encostar, morre? */
    protected boolean bQuebravel; /* Pode quebrar? */
    protected boolean bColetavel; /* Coletavel? */
    protected boolean bMovivel; /* Pode mover? */
    protected boolean bEsteira; /* Empura outro objeto? */
    protected boolean bPowerUp; /* Libera PowerUp? */

    // Construtor de elemento que recebe uma imagem a ser carregada
    protected Elemento(String sNomeImagePNG) {
        // Inicializa uma posicao qualquer
        this.pPosicao = new Posicao(1, 1);
        this.bTransponivel = true;
        this.bMortal = false;
        this.bQuebravel = false;
        this.bMovivel = false;
        this.bEsteira = false;
        this.bPowerUp = false;
        try {
            iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG);
            Image img = iImage.getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
            iImage = new ImageIcon(bi);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Funcao que recebe um nome de imagem para mudar a imagem do elemento
    public void setImage(String sNomeImagePNG) {
        try {
            iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG);
            Image img = iImage.getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
            iImage = new ImageIcon(bi);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Getters
    public Posicao getPosicao() {
        return pPosicao;
    }

    public boolean isbTransponivel() {
        return bTransponivel;
    }

    public boolean isbMortal() {
        return bMortal;
    }

    public boolean isbQuebravel() {
        return bQuebravel;
    }

    public boolean isbColetavel() {
        return bColetavel;
    }

    public boolean isbMovivel() {
        return bMovivel;
    }

    public boolean isbEsteira() {
        return bEsteira;
    }

    public boolean isbPowerUp() {
        return bPowerUp;
    }

    // Setters
    public void setbTransponivel(boolean bTransponivel) {
        this.bTransponivel = bTransponivel;
    }

    public boolean setPosicao(int linha, int coluna) {
        return pPosicao.setPosicao(linha, coluna);
    }

    public boolean setPosicao(Posicao umaPosicao) {
        return pPosicao.copia(umaPosicao);
    }

    // Funcoes de movimento do elemento
    public boolean moveUp() {
        return this.pPosicao.moveUp();
    }

    public boolean moveDown() {
        return this.pPosicao.moveDown();
    }

    public boolean moveRight() {
        return this.pPosicao.moveRight();
    }

    public boolean moveLeft() {
        return this.pPosicao.moveLeft();
    }

    // Funcao para printar o elemento na tela
    public void autoDesenho() {
        Desenhador.desenhar(this.iImage, pPosicao.getColuna(), pPosicao.getLinha());
    }
}
