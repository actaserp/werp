﻿/*!
    *
    * Wijmo Library 5.20221.842
    * http://wijmo.com/
    *
    * Copyright(c) GrapeCity, Inc.  All rights reserved.
    *
    * Licensed under the GrapeCity Commercial License.
    * sales@wijmo.com
    * wijmo.com/products/wijmo-5/license/
    *
    */

var wijmo;!function(e){window.wijmo||(window.wijmo=e);var r={Globalize:{name:"fr-CA",displayName:"French (Canada)",numberFormat:{".":",",",":" ","-":"-","+":"+","%":"%",percent:{pattern:["-n %","n %"]},currency:{decimals:2,symbol:"$",pattern:["(n $)","n $"]}},calendar:{"/":"-",":":":",firstDay:0,days:["dimanche","lundi","mardi","mercredi","jeudi","vendredi","samedi"],daysAbbr:["dim.","lun.","mar.","mer.","jeu.","ven.","sam."],months:["janvier","février","mars","avril","mai","juin","juillet","août","septembre","octobre","novembre","décembre"],monthsAbbr:["janv.","févr.","mars","avr.","mai","juin","juil.","août","sept.","oct.","nov.","déc."],am:["",""],pm:["",""],eras:["ap. J.-C."],patterns:{d:"yyyy-MM-dd",D:"d MMMM yyyy",f:"d MMMM yyyy HH:mm",F:"d MMMM yyyy HH:mm:ss",t:"HH:mm",T:"HH:mm:ss",m:"d MMMM",M:"d MMMM",y:"MMMM, yyyy",Y:"MMMM, yyyy",g:"yyyy-MM-dd HH:mm",G:"yyyy-MM-dd HH:mm:ss",s:'yyyy"-"MM"-"dd"T"HH":"mm":"ss'},fiscalYearOffsets:[3,3]}},Licensing:{cls:"FERMER",ctc:'S’il vous plaît contacter GrapeCity: <a href="mailto:us.sales@grapecity.com"> us.sales@grapecity.com</a>.',dmn:"La licence de Wijmo dans la présente demande n’est pas valable pour le domaine actuel. Le domaine de la licence est <b>{licDomain}</b>; le domaine actuel est <b>{domain}</b>.",evl:"Version d’évaluation de Wijmo ({version})",exp:"La licence de Wijmo dans la présente demande a expiré. Date d’expiration de la licence est <b>{expDate:d}</b>.",hdr:"Licence Wijmo",lic:"La licence de Wijmo dans la présente demande n’est pas valide.",mss:"La licence de Wijmo dans la présente demande n’est pas définie.",prd:"La licence de Wijmo dans la présente demande n’est pas valide pour le contrôle de <b>{control}</b>  .",ver:"La licence de Wijmo dans la présente demande n’est pas valide pour la version en cours d’utilisation. La version de la licence est  <b>{licVer}</b>; la version du produit est <b>{version}</b>."},Calendar:{ariaLabels:{calendar:"Calendrier",monthView:"Affichage du mois",yearView:"Vue de l’année",prvMo:"Mois précédent",today:"Aujourd'hui",nxtMo:"Mois prochain",prvYr:"Année précédente",currMo:"Mois en cours",nxtYr:"Année prochaine"}},DropDown:{ariaLabels:{tgl:"Liste déroulante activer/désactiver"}},FlexGrid:{groupHeaderFormat:"{name} : <b>{value}</b> ({count:n0} articles)",ariaLabels:{toggleDropDown:"Liste déroulante activer/désactiver",toggleGroup:"Activer/désactiver groupe"}},FlexGridDetailProvider:{ariaLabels:{toggleDetail:"Activer/désactiver ligne détail"}},FlexGridFilter:{ariaLabels:{edit:"Modifier le filtre pour la colonne",dialog:"Éditeur de filtre pour la colonne",asc:"Colonne de tri en ordre croissant",dsc:"Colonne de tri en ordre décroissant",search:"Liste d’éléments de recherche",op1:"Premier opérateur de Condition",val1:"Première Condition valeur",and:"Il faut effectuer les deux Conditions",or:"Besoin d’une Condition",op2:"Deuxième opérateur de Condition",val2:"Seconde valeur de la Condition"},ascending:"↑ Croissant",descending:"↓ Décroissant",apply:"Appliquer",cancel:"Annuler",clear:"Effacer",conditions:"Filtrer par État",values:"Filtrer par valeur",search:"Rechercher",selectAll:"Sélectionner tous les éléments",null:"(rien)",header:"Afficher les articles où la valeur",and:"Et",or:"Ou",stringOperators:[{name:"(non défini)",op:null},{name:"Est égal à",op:0},{name:"N’est pas égal à",op:1},{name:"Commence par",op:6},{name:"Se termine par",op:7},{name:"Contient",op:8},{name:"Ne contient pas",op:9}],numberOperators:[{name:"(non défini)",op:null},{name:"Est égal à",op:0},{name:"N’est pas égal à",op:1},{name:"Est supérieure à",op:2},{name:"Est supérieur ou égal à",op:3},{name:"Est inférieure à",op:4},{name:"Est inférieur ou égal à",op:5}],dateOperators:[{name:"(non défini)",op:null},{name:"Est égal à",op:0},{name:"Est avant",op:4},{name:"Est après",op:2}],booleanOperators:[{name:"(non défini)",op:null},{name:"Est égal à",op:0},{name:"N’est pas égal à",op:1}]},GroupPanel:{dragDrop:"Drag and Drop colonnes ici pour créer des groupes."},InputDateTime:{ariaLabels:{tglDate:"Calendrier de la bascule",tglTime:"Liste de moment de bascule"}},InputNumber:{ariaLabels:{incVal:"Augmenter la valeur",decVal:"Diminution de la valeur"}},MultiSelect:{itemsSelected:"{count:n0} articles sélectionnés"},MultiSelectListBox:{filterPlaceholder:"Filtrer",selectAll:"Sélectionner tout"},olap:{PivotFieldEditor:{dialogHeader:"Paramètres de champ:",header:"En-tête:",summary:"Résumé:",showAs:"Afficher comme:",weighBy:"Poids de:",sort:"Tri par:",filter:"Filtre:",format:"Format:",sample:"Échantillon:",edit:"Modifier…",clear:"Effacer",ok:"OK",cancel:"Annuler",none:"(aucun)",sorts:{asc:"Croissant",desc:"Décroissant"},aggs:{sum:"Somme",cnt:"Nombre",avg:"Moyenne",max:"Max.",min:"Min.",rng:"Plage",std:"StdDev",var:"Var",stdp:"StdDevPop",varp:"VarPop",first:"Premier",last:"Dernier"},calcs:{noCalc:"Aucun calcul",dRow:"Différence du rang précédent",dRowPct:"% différence du rang précédent",dCol:"Différence de la colonne précédente",dColPct:"% différence de la colonne précédente",dPctGrand:"% du total général",dPctRow:"% du total de ligne",dPrevRow:"% de la valeur de la ligne précédente",dPctCol:"% de colonne total",dPrevCol:"% de la valeur dans la colonne précédente",dRunTot:"Total cumulé",dRunTotPct:"% total cumulé"},formats:{n0:"Entier (n0)",n2:"Décimal (n2)",c:"Monnaie (c)",p0:"Pourcentage (p0)",p2:"Pourcentage (p2)",n2c:"Des milliers (n2,)",n2cc:"Des millions (n2,,)",n2ccc:"Des milliards (n2,,,)",d:"Date (d)",MMMMddyyyy:"Mois jour année (MMMM dd, yyyy)",dMyy:"Jour mois année (d/M/yy)",ddMyy:"Jour mois année (dd/M/yy)",dMyyyy:"Jour mois année (dd/M/yyyy)",MMMyyyy:"Mois année (MMM yyyy)",MMMMyyyy:"Mois année (MMMM yyyy)",yyyy:"Année (yyyy)",yyyyQq:'Trimestre de l’année (yyyy "Q"q)',FYEEEEQU:'Trimestre de l’exercice ("FY"EEEE "Q"U)'}},PivotEngine:{grandTotal:"Total général",subTotal:"Sous-total"},PivotPanel:{fields:"Choisissez les champs à ajouter au rapport:",drag:"Faites glisser les champs entre les zones ci-dessous:",filters:"Filtres",cols:"Colonnes",rows:"Lignes",vals:"Valeurs",defer:"Reporter les mises à jour",update:"Mettre à jour"},_ListContextMenu:{up:"Monter",down:"Descendre",first:"Passer au début",last:"Déplacer vers la fin",filter:"Passer au filtre de rapport",rows:"Déplacer vers les étiquettes de ligne",cols:"Déplacer vers les étiquettes de colonne",vals:"Se déplacer aux valeurs",remove:"Supprimer le champ",edit:"Paramètres de champ…",detail:"Afficher le détail…"},PivotChart:{by:"par",and:"et"},DetailDialog:{header:"Vue de détail:",ok:"OK",items:"éléments de {cnt:n0}",item:"élément de {cnt}",row:"Ligne",col:"Colonne"},Slicer:{multiSelect:"Sélection multiple",clearFilter:"Effacer le filtre"}},Viewer:{cancel:"Annuler",ok:"OK",bottom:"En bas:",top:"Retour au début:",right:"A droite:",left:"A gauche:",margins:"Marges (pouces)",orientation:"Orientation:",paperKind:"Type de papier:",pageSetup:"Mise en page",landscape:"Paysage",portrait:"Portrait",pageNumber:"Numéro de page",zoomFactor:"Facteur de zoom",paginated:"Mise en page",print:"Impression",search:"Rechercher",matchCase:"Respecter la casse",wholeWord:"Mot entier",searchResults:"Résultats de la recherche",previousPage:"Page précédente",nextPage:"Page suivante",firstPage:"Première page",lastPage:"Dernière page",backwardHistory:"En arrière",forwardHistory:"Transférer",pageCount:"Nombre de pages",selectTool:"Sélectionnez l’outil",moveTool:"Outil de déplacement",continuousMode:"Affichage de la Page continue",singleMode:"Affichage de Page simple",wholePage:"Toute forme de la Page",pageWidth:"Largeur de la Page",zoomOut:"Zoom arrière",zoomIn:"Zoom avant",rubberbandTool:"Zoom par sélection",magnifierTool:"Loupe",rotatePage:"Faire pivoter la page",rotateDocument:"Faire pivoter le document",exports:"Exporter",fullScreen:"Plein écran",exitFullScreen:"Quitter le mode plein écran",hamburgerMenu:"Outils",showSearchBar:"Afficher la barre de recherche",viewMenu:"Options de mise en",searchOptions:"Options de recherche",matchCaseMenuItem:"Respecter la casse",wholeWordMenuItem:"Mot entier",thumbnails:"Vignettes de page",outlines:"Explorateur de documents",loading:"Chargement…",pdfExportName:"Adobe PDF",docxExportName:"Open XML Word",xlsxExportName:"Open XML Excel",docExportName:"Microsoft Word",xlsExportName:"Microsoft Excel",mhtmlExportName:"Archive Web (MHTML)",htmlExportName:"Document HTML",rtfExportName:"Document RTF",metafileExportName:"Métafichiers compressés",csvExportName:"CSV",tiffExportName:"Images TIFF",bmpExportName:"Images BMP",emfExportName:"Métafichier amélioré",gifExportName:"Images GIF",jpgExportName:"Images JPEG",jpegExportName:"Images JPEG",pngExportName:"Images PNG",abstractMethodException:"Il s’agit d’une méthode abstraite, s’il vous plaît mettre en œuvre.",cannotRenderPageNoViewPage:"Ne peut pas rendre la page sans la source du document et page d’affichage.",cannotRenderPageNoDoc:"Ne peut pas rendre la page sans la source du document et page d’affichage.",exportFormat:"Format d’exportation :",exportOptionTitle:"Options d'exportation",documentRestrictionsGroup:"Restrictions de document",passwordSecurityGroup:"Sécurité de mot de passe",outputRangeGroup:"Gamme de sortie",documentInfoGroup:"Document info",generalGroup:"Général",docInfoTitle:"Titre",docInfoAuthor:"Auteur",docInfoManager:"Directeur",docInfoOperator:"Opérateur",docInfoCompany:"Société",docInfoSubject:"Sujet",docInfoComment:"Commentaire",docInfoCreator:"Créateur",docInfoProducer:"Producteur",docInfoCreationTime:"Heure de création",docInfoRevisionTime:"Temps de révision",docInfoKeywords:"Mots clés",embedFonts:"Incorporer les polices TrueType",pdfACompatible:"Compatible PDF/A (niveau 2 b)",useCompression:"Utiliser compression",useOutlines:"Générer des contours",allowCopyContent:"Autoriser la copie de contenu ou l’extraction",allowEditAnnotations:"Autoriser la modification d’annotation",allowEditContent:"Autoriser la modification des contenus",allowPrint:"Autoriser l’impression",ownerPassword:"Mot de passe autorisations (propriétaire) :",userPassword:"Mot de passe document ouvert (utilisateur) :",encryptionType:"Niveau de cryptage :",paged:"Paginée",showNavigator:"Voir la Navigator",navigatorPosition:"Position du navigateur",singleFile:"Fichier unique",tolerance:"La tolérance lors de la détection de texte délimite (points) :",pictureLayer:"Utiliser la couche photo séparé",metafileType:"Type de métafichier :",monochrome:"Monochrome",resolution:"Résolution :",outputRange:"Plage de pages :",outputRangeInverted:"Inversé",showZoomBar:"Barre de zoom",searchPrev:"Recherche précédente",searchNext:"Rechercher ensuite",checkMark:"✓",exportOk:"Exporter…",cannotSearch:"La recherche nécessite une source de document à spécifier.",parameters:"Paramètres",requiringParameters:"S’il vous plaît entrer des paramètres.",nullParameterError:"Valeur ne peut pas être null.",invalidParameterError:"Entrée non valide.",parameterNoneItemsSelected:"(aucun)",parameterAllItemsSelected:"(tous)",parameterSelectAllItemText:"(Sélectionner tout)",selectParameterValue:"(sélectionnez valeur)",apply:"Appliquer",errorOccured:"Une erreur s’est produite."},FlexSheet:{insertRow:"Insérer une ligne",deleteRow:"Supprimer une ligne",insertCol:"Insérer une colonne",deleteCol:"Supprimer une colonne",convertTable:"Convertir le tableau",copyCells:"Copier des cellules",fillSeries:"Séries de remplissages",fillFormat:"Remplir seulement de mise en forme",fillWithoutFormat:"Remplir sans formatage",insertSheet:"Insérer",deleteSheet:"Supprimer",renameSheet:"Renommer"},FlexChartAnalytics:{BreakEven:{profitArea:"Zone de profit",lossArea:"Zone de perte",safetyMargin:"Marge de sécurité",salesRevenue:"Recettes de ventes",totalCost:"Coût total",fixedCost:"Coût fixe",variableCost:"Coût variable",marginalProfit:"Bénéfice marginal",breakEven:"Atteindre l'équilibre"}}},a=window.wijmo._updateCulture;a?a(r):window.wijmo.culture=r}(wijmo||(wijmo={}));