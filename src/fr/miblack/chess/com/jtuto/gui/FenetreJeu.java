package fr.miblack.chess.com.jtuto.gui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;



public class FenetreJeu extends JFrame implements KeyListener {
	/**
    * 
    */
   private static final long serialVersionUID = 1L;
	protected Object leModeleDeJeu = null;
	private PanneauJeu lePanneauDeJeu = new PanneauJeu( this );
	private GestionnaireEvenements ge = null;

	private Font policeCourante = null;

	/**
	 * Fonction d'initialisation de la fenetre
	 */
	public void init() {
		policeCourante = this.getFont( );
		this.setFocusable( true );
		
	}

	/**
	 * Retourne le gestionnaire d'evenements
	 * @return the ge
	 */
	public GestionnaireEvenements lireGestionnaireEvenements() {
		return ge;
	}

	/**
	 * Fixe le gestionnaire d'evenemments.
	 * Une instance d'une classe implementant l'interface GestionnaireEvenemments
	 * @param ge
	 *        
	 */
	public void fixerGestionnaireEvenements( GestionnaireEvenements ge ) {
		this.ge = ge;
	}

	/**
	 * Constructeur. Cree une fenetre de Jeu de dimension 400x300 par defaut.
	 * Cree cette fenetre avec un titre vide
	 */
	public FenetreJeu() {
		this.setName( "Jeu" );
		// lePanneauDeJeu.setSize( largeur , hauteur );
		Container c = this.getContentPane( );
		c.add( lePanneauDeJeu , "Center" );
		// lePanneauDeJeu.setBackground( Couleur.LIGHT_GRAY );
		this.pack( );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setLocation( 100 , 100 );
		this.setSize( 400 , 300 );
		this.setTitle( "" );
		this.setResizable( false );
		this.addKeyListener( this );
		init( );
	}

   /**
    * Constructeur avec parametres :	
    * 
    * @param nom : nom de la fenetre ( String )
    * @param xGauche : abscisse du coin superieur gauche ( int )
    * @param yHaut : ordonnee du coin superieur droit ( int )
    * @param titre : titre de la fenetre ( String ) 
    * @param largeur : largeur de la fenetre ( int )
    * @param hauteur : hauteur de la fenetre (int )
    * @param fond : couleur du fond ( Couleur )
    */
	public FenetreJeu( String nom , int xGauche , int yHaut , String titre ,
	      int largeur , int hauteur , Couleur fond ) {
		this.setName( nom );
		Container c = this.getContentPane( );
		c.add( lePanneauDeJeu , "Center" );
		lePanneauDeJeu.setBackground( fond );
		this.pack( );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setLocation( xGauche , yHaut );
		this.setSize( largeur , hauteur );
		this.setTitle( titre );
		this.setResizable( false );
		this.addKeyListener( this );
		init( );
	}

	/**
	 * Affiche la fenetre tout en raffraichissant l'ecran
	 */
	public void afficher() {
		setVisible( true );
		raffraichirEcran( );
	}

	/**
	 * Permet de fixer le titre de la fenetre
	 * @param titre
	 */
	public void fixerTitre( String titre ) {
		setTitle( titre );
	}

	/**
	 * Permet de changer le nom de la fenetre
	 * @param nom
	 */
	public void fixerNom( String nom ) {
		setName( nom );
	}

	/**
	 * Permet de changer les dimensions de la fenetre
	 * @param largeur
	 * @param hauteur
	 */
	public void dimensionner( int largeur , int hauteur ) {
		this.setSize( largeur , hauteur );
	}

	/**
	 * Permet de changer la positio de la fenetre 
	 * @param x
	 * @param y
	 */
	public void positionner( int x , int y ) {
		this.setLocation( x , y );
	}

	/**
	 * Permet de changer la couleur de fond de la fenetre
	 * @param fond
	 */
	public void fixerCouleurDeFond( Couleur fond ) {
		lePanneauDeJeu.setBackground( fond );
		lePanneauDeJeu.repaint( );
	}
   /**
    * Permet de changer la police de caracteres courante
    * @param nomPolice
    * @param style
    * @param taille
    */
	public void fixerPoliceCourante( String nomPolice , int style , int taille ) {
		policeCourante = new Font( nomPolice , style , taille );
	}

	/**
	 * Permet de creer un Objet ligne sur la fenetre.
	 * Cet objet sera repere par son identificateur id
	 * Cette ligne sera enregistre sur la couche par defaut
	 * 
	 * @param id : identifiant de la ligne
	 * @param x1 : abscisse du point de depart
	 * @param y1 : ordonnee du point de depart
	 * @param x2 : abscisse du point d arrivee
	 * @param y2 : ordonnee du point d arrivee
	 * @param couleur : Couleur de la ligne
	 */
	public void creerLigne( String id , int x1 , int y1 , int x2 , int y2 ,
	      Couleur couleur ) {
		lePanneauDeJeu.enregistreLigne( id , x1 , y1 , x2 , y2 , couleur );
	}

	/**
	 * Permet de creer un Objet ligne sur la fenetre sur la couche couche.
	 * Cet objet sera repere par son identificateur id
	 * Cette ligne sera enregistre sur la couche numero couche
	 * 
	 * @param id : identifiant de la ligne
	 * @param x1 : abscisse du point de depart
	 * @param y1 : ordonnee du point de depart
	 * @param x2 : abscisse du point d arrivee
	 * @param y2 : ordonnee du point d arrivee
	 * @param couleur : Couleur de la ligne
	 * @param couche : numero de couche
	 */
	public void creerLigne( String id , int x1 , int y1 , int x2 , int y2 ,
	      Couleur couleur , int couche ) {
		lePanneauDeJeu
		      .enregistreLigne( id , x1 , y1 , x2 , y2 , couleur , couche );
	}

	/**
	 * Permet de creer et d'afficher un rectangle rempli ou non.
	 * 
	 * @param id : identifiant du rectangle
	 * @param xGauche : abscisse du point superieur gauche
	 * @param yHaut : ordonnee du point superieur gauche
	 * @param longueur : longueur du rectangle
	 * @param hauteur : hauteur du rectangle
	 * @param plein : le rectangle est rempli si vrai
	 * @param couleur : couleur du rectangle
	 */
	public void creerRectangle( String id , int xGauche , int yHaut ,
	      int longueur , int hauteur , boolean plein , Couleur couleur ) {
		lePanneauDeJeu.enregistreRectangle( id , xGauche , yHaut , longueur ,
		      hauteur , couleur , plein );
	}

	/**
	 * Permet de creer et d'afficher un rectangle rempli ou non sur la couche
	 * de numero couche.
	 * 
	 * @param id : identifiant du rectangle
	 * @param xGauche : abscisse du point superieur gauche
	 * @param yHaut : ordonnee du point superieur gauche
	 * @param longueur : longueur du rectangle
	 * @param hauteur : hauteur du rectangle
	 * @param plein : le rectangle est rempli si vrai
	 * @param couleur : couleur du rectangle
	 * @param couche : numero de la couche
	 */
	
	public void creerRectangle( String id , int xGauche , int yHaut ,
	      int longueur , int hauteur , boolean plein , Couleur couleur ,
	      int couche ) {
		lePanneauDeJeu.enregistreRectangle( id , xGauche , yHaut , longueur ,
		      hauteur , couleur , plein , couche );
	}

	/**
	 * Permet de creer et d'afficher un texte avec la police courante.
	 * @param id
	 * @param xGauche
	 * @param yHaut
	 * @param texte
	 * @param couleurTexte
	 */
	public void creerTexte( String id , int xGauche , int yHaut , String texte ,
	      Couleur couleurTexte ) {
		lePanneauDeJeu.enregistreTexte( id , policeCourante , xGauche , yHaut ,
		      texte , couleurTexte );
	}

	public void creerTexte( String id , int xGauche , int yHaut , String texte ,
	      Couleur couleurTexte , int couche ) {
		lePanneauDeJeu.enregistreTexte( id , policeCourante , xGauche , yHaut ,
		      texte , couleurTexte , couche );
	}

	public void creerOval( String id , int xCentre , int yCentre , int largeur ,
	      int hauteur , boolean plein , Couleur couleur ) {
		lePanneauDeJeu.enregistreOval( id , xCentre , yCentre , largeur ,
		      hauteur , couleur , plein );
	}

	public void creerOval( String id , int xCentre , int yCentre , int largeur ,
	      int hauteur , boolean plein , Couleur couleur , int couche ) {
		lePanneauDeJeu.enregistreOval( id , xCentre , yCentre , largeur ,
		      hauteur , couleur , plein , couche );
	}

	public void creerTriangle( String id , int x1 , int y1 , int x2 , int y2 ,
	      int x3 , int y3 , Color c , boolean plein , int couche ) {
		lePanneauDeJeu.enregistreTriangle( id , x1 , y1 , x2 , y2 , x3 , y3 , c ,
		      plein , couche );
	}

	public void creerTriangle( String id , int x1 , int y1 , int x2 , int y2 ,
	      int x3 , int y3 , Color c , boolean plein ) {
		lePanneauDeJeu.enregistreTriangle( id , x1 , y1 , x2 , y2 , x3 , y3 , c ,
		      plein );
	}

	public void creerImage( String id , int x , int y , int largeur , int hauteur , String fichierImage , int numCouche )
	{
	  lePanneauDeJeu.enregistreImage( id , x , y , largeur , hauteur , fichierImage , numCouche );  	
	}
	
	
	/**
	 * Boite de saisie
	 * @param message
	 * @param libelle
	 * @return : la chaine saisie dans la boite de saisie
	 */
	public String boiteDeSaisie( String message , String libelle ) {
		return JOptionPane.showInputDialog( libelle , message );
	}

	public  void boiteDeMessage( String message , String libelle ) {
		JOptionPane.showMessageDialog( this , libelle , message , 0 );
	}

	public static void attendre( long millis ) {
		long debut = System.currentTimeMillis( );
		while (System.currentTimeMillis( ) - debut < millis)
			;
	}

	public void ajouterBouton( String nomComposant , int xGauche , int yHaut ,
	      int largeur , int hauteur , String titre , Couleur couleurBouton ,
	      Couleur couleurTexte ) {
		JButton jb = new JButton( titre );
		jb.setName( nomComposant );
		if (couleurBouton != null)
			jb.setBackground( couleurBouton );
		if (couleurTexte != null)
			jb.setForeground( couleurTexte );
		jb.setBorder( new BevelBorder( BevelBorder.RAISED ) );
		jb.setFont( policeCourante );
		lePanneauDeJeu.add( jb );
		lePanneauDeJeu.enregistrerComposant( nomComposant , jb );
		jb.setBounds( xGauche , yHaut , largeur , hauteur );
		jb.addActionListener( new EcouteurBouton( nomComposant ) );
		jb.setFocusable( false );
		jb.repaint( );
		
	}

	public void ajouterZoneDeTexte( String nomComposant , int xGauche ,
	      int yHaut , int largeur , int hauteur , String texte ,
	      Couleur couleurZone , Couleur couleurTexte ) {
		JLabel jb = new JLabel( texte );
		jb.setName( nomComposant );
		if (couleurZone != null)
			jb.setBackground( couleurZone );
		if (couleurTexte != null)
			jb.setForeground( couleurTexte );
		// jb.setBorder( new BevelBorder( BevelBorder.RAISED));
		jb.setFont( policeCourante );
		lePanneauDeJeu.add( jb );
		lePanneauDeJeu.enregistrerComposant( nomComposant , jb );
		jb.setBounds( xGauche , yHaut , largeur , hauteur );
		jb.setFocusable( false );
		jb.repaint( );
	
	}

	public void ajouterZoneDeSaisie( String nomComposant , int xGauche ,
	      int yHaut , int largeur , int hauteur , Couleur couleurZone ,
	      Couleur couleurTexte ) {
		JTextField jb = new JTextField( );
		jb.setName( nomComposant );
		if (couleurZone != null)
			jb.setBackground( couleurZone );
		if (couleurTexte != null)
			jb.setForeground( couleurTexte );
		jb.setBorder( new BevelBorder( BevelBorder.LOWERED ) );
		jb.setFont( policeCourante );
		lePanneauDeJeu.add( jb );
		lePanneauDeJeu.enregistrerComposant( nomComposant , jb );
		jb.setBounds( xGauche , yHaut , largeur , hauteur );
      jb.setFocusable( true );
		jb.repaint( );
	}

	
	public void ajouterComposantSwing( String nomComposant , JComponent composantSwing , int xGauche ,
                                      int yHaut , int largeur , int hauteur )
	{
		
		lePanneauDeJeu.add( composantSwing );
		lePanneauDeJeu.enregistrerComposant( nomComposant , composantSwing );
		composantSwing.setBounds( xGauche, yHaut , largeur , hauteur  );
		composantSwing.repaint( );
	}
	
	public JComponent lireComposantSwing( String nomComposant )
	{
		return lePanneauDeJeu.lireComposantSwing( nomComposant );
	}
	
	
	public void effacerEcranComplet() {
		lePanneauDeJeu.effacer( );
	}

	public boolean existeIdDeDessin( String id ) {
		return lePanneauDeJeu.existeIdElementDeDessin( id );
	}

	public boolean existeIdComposant( String id ) {
		return lePanneauDeJeu.existeIdComposant( id );
	}

	public boolean retirerComposantGraphique( String nomComposant ) {
		return lePanneauDeJeu.retirerComposant( nomComposant );
	}

	public boolean retirerElementDeDessin( String identifiant ) {
		return lePanneauDeJeu.retirerElement( identifiant );
	}

	public void retirerElementsDeDessinParPattern( String regex ) {
		lePanneauDeJeu.retirerElementParPattern( regex );
	}

	public void retirerElementsDeDessinParCouche( int numCouche ) {
		lePanneauDeJeu.retirerElementsParCouche( numCouche );
	}
	
	
	
	public boolean fixerDisponibiliteComposant( String nomComposant ,
	      boolean dispo ) {
		return lePanneauDeJeu.fixerDisponibilite( nomComposant , dispo );
	}

	public boolean lireDisponibiliteComposant( String nomComposant ) {
		return lePanneauDeJeu.lireDisponibilite( nomComposant );
	}

	public void raffraichirEcran() {
		lePanneauDeJeu.raffraichirEcran( );
	}

	public String lireTexteComposant( String nomComposant ) {
		return lePanneauDeJeu.lireTexteComposant( nomComposant );
	}

	public boolean ecrireTexteComposant( String nomComposant , String valeur ) {
		return lePanneauDeJeu.ecrireTexteComposant( nomComposant , valeur );
	}
	private class EcouteurBouton implements ActionListener {
		private String nomBouton;

		public EcouteurBouton( String nomBouton ) {
			this.nomBouton = nomBouton;
		}

		public void actionPerformed( ActionEvent e ) {
			if (getGe() != null)
				getGe().gereEvenement( nomBouton , 1 , "" , -1 , -1 );
		}
	}

	public GestionnaireEvenements getGe()
	{
		return ge;
	}

	public void setGe( GestionnaireEvenements ge )
	{
		this.ge = ge;
	}


	
	/**
	 * @return the leModeleDeJeu
	 */
	public Object lireModeleDeJeu() {
		return leModeleDeJeu;
	}

	/**
	 * @param leModeleDeJeu
	 *           the leModeleDeJeu to set
	 */
	public void enregistrerModeleDeJeu( Object leModeleDeJeu ) {
		this.leModeleDeJeu = leModeleDeJeu;
	}

	@Override
   public void keyPressed( KeyEvent e ) {
		//System.out.println("Key");
	   lePanneauDeJeu.keyPressed( e );
   }

	@Override
   public void keyReleased( KeyEvent e ) {
		//System.out.println("Key");
		lePanneauDeJeu.keyReleased( e );
   }

	@Override
   public void keyTyped( KeyEvent e ) {
		//System.out.println("Key");
		lePanneauDeJeu.keyTyped( e );
   }
	
	
	public void animerFormeJusqua( String idForme , int x , int y , int nbAnimations , int delai , boolean bloquant)
	{
		
		lePanneauDeJeu.animerFormeJusqua( idForme , x , y , nbAnimations  , delai , bloquant);
	}
	
	
	
	public void fixerImageDeFond( String fichierImage )
	{
		afficher( );
		lePanneauDeJeu.fixerImageDeFond( fichierImage );
	}
	
	
	public String lireIdObjetSelectionne( int x , int y )
	{
	   return lePanneauDeJeu.lireIdObjetSelectionne( x , y );
	}
	
	public void translaterElementDeDessin( String elementId , int dx , int dy ) 
	{
			lePanneauDeJeu.translaterElementDeDessin( elementId , dx , dy );
			raffraichirEcran( );
	
	}
	
	 public void selectionnerObjet( String id )
	   {
		  lePanneauDeJeu.selectionnerObjet( id );
		  raffraichirEcran( );
	   }
	   
	   
	   public void deselectionnerObjet( String id )
	   {
	   	lePanneauDeJeu.deselectionnerObjet( id );
	   	raffraichirEcran( );
	   }
	   
	   public void fixerCouleurDeSelection( Couleur c )
	   {
	   	lePanneauDeJeu.fixerCouleurDeSelection( c );
	   }
	   
	   public Couleur lireCouleurDeSelection()
	   {
	   	return lePanneauDeJeu.lireCouleurDeSelection( );
	   }
	   
	
	   public void fixerAspectDeLaSouris( int typeDeCurseur )
	   {
	   	switch( typeDeCurseur )
	   	{
	   		case Constantes.SOURIS_NORMALE :
	   		   lePanneauDeJeu.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ));
	   			break;
	   		case Constantes.SOURIS_MAIN :
	   			 lePanneauDeJeu.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ));
	   			break;
	   		case Constantes.SOURIS_SABLIER :
	   			 lePanneauDeJeu.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ));
	   			break;
	   	}
	   }
	   
	
	
}