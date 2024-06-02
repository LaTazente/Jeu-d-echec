Jeu d'Échecs en Java avec Slick2D
Mission
Le projet consiste à développer un jeu d'échecs interactif en 2D en utilisant la bibliothèque graphique Slick2D pour Java. L'objectif principal est de créer un jeu d'échecs complet, incluant toutes les règles standard, avec une interface utilisateur intuitive et réactive. Le jeu doit permettre à deux joueurs de s'affronter sur un même ordinateur, avec des fonctionnalités supplémentaires telles que la sauvegarde et le chargement des parties, ainsi qu'un suivi des mouvements.

Tâches
Configuration du Projet :

Configurer l'environnement de développement Java avec Slick2D et LWJGL.
Créer la structure initiale du projet.
Développement du Plateau de Jeu :

Dessiner le plateau d'échecs en 2D.
Implémenter l'affichage graphique des cases et des coordonnées.
Modélisation des Pièces d'Échecs :

Créer les classes Java pour chaque type de pièce (Roi, Reine, Tour, Fou, Cavalier, Pion).
Définir les mouvements valides pour chaque pièce selon les règles des échecs.
Implémentation de la Logique de Jeu :

Gérer les règles de déplacement des pièces.
Implémenter les règles spécifiques (roque, prise en passant, promotion des pions).
Vérifier les conditions de victoire (échec et mat, pat).
Gestion des Interactions Utilisateur :

Implémenter la gestion des clics de souris pour sélectionner et déplacer les pièces.
Mettre à jour l'affichage en fonction des mouvements.
Ajout de Fonctionnalités Supplémentaires :

Sauvegarde et chargement des parties.
Affichage des mouvements précédents.
Réinitialisation du jeu.
Tests et Débogage :

Tester toutes les fonctionnalités pour s'assurer du bon fonctionnement.
Corriger les bugs et optimiser les performances.
Outils Techniques
Langage de Programmation : Java
Bibliothèque Graphique : Slick2D
Bibliothèque de Support : LWJGL (Lightweight Java Game Library)
Environnement de Développement : IntelliJ IDEA ou Eclipse
Contrôle de Version : Git et GitHub pour la gestion du code source et la collaboration.
Système de Gestion de Projet : Trello ou Jira pour suivre les tâches et les progrès du projet.
Tests Unitaires : JUnit pour tester les composants individuels du jeu.
Documentation : Javadoc pour générer la documentation du code.
Détails Techniques
Configuration Initiale :

Télécharger et ajouter les fichiers JAR de Slick2D et LWJGL au projet.
Configurer le classpath pour inclure les bibliothèques nécessaires.
Plateau de Jeu :

Utiliser Slick2D pour dessiner le plateau de jeu et les pièces.
Assurer une mise à jour fluide de l'interface graphique.
Pièces d'Échecs :

Classes Java pour chaque pièce héritant d'une classe de base ChessPiece.
Méthodes pour vérifier la validité des mouvements et gérer les captures.
Logique de Jeu :

Implémenter une classe ChessGame pour gérer l'état du jeu et les interactions entre les pièces.
Gérer les tours des joueurs et vérifier les règles spécifiques.
Interface Utilisateur :

Utiliser les événements de souris de Slick2D pour gérer les sélections et déplacements.
Mettre en place des boutons et des menus pour les fonctionnalités supplémentaires.
Sauvegarde et Chargement :

Utiliser la sérialisation pour sauvegarder l'état du jeu.
Permettre aux utilisateurs de charger des parties sauvegardées.
