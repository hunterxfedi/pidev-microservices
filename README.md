README - Plateforme de Gestion des Stages Universitaires
🎯 Objectif du projet
Ce projet est une plateforme web destinée à la gestion des stages au sein de la faculté. Elle permet de digitaliser tout le processus de stage : de la recherche à la soutenance finale, en passant par le suivi administratif et l'encadrement pédagogique.
👥 Utilisateurs cibles
- Étudiants
- Enseignants encadrants
- Agents administratifs
✨ Fonctionnalités principales
- Recherche et candidature à des offres de stages
- Dépôt de livrables à chaque étape
- Gestion des soutenances
- Suivi et validation des documents
- Notifications (emails)
- Tableau de bord de suivi
- Gestion des offres de stages par les entreprises
🧱 Technologies utilisées
**Back-end**:
- Java 17
- Spring Boot
- MongoDB
- Spring Data
- Spring Security
- Swagger/OpenAPI
- EmailService

**Front-end**:
- Angular 17+
- TypeScript
- Bootstrap / Tailwind
- Angular Material
📦 Installation du projet
**Back-end (Spring Boot)**:
```
cd backend
mvn spring-boot:run
```

**Front-end (Angular)**:
```
cd frontend
npm install
ng serve
```
📂 Structure du projet
📁 backend
 └── 📁 src
      └── 📁 main
           ├── 📁 java
           │    └── org.example.livrablemicro
           └── 📁 resources
                ├── application.properties

📁 frontend
 └── 📁 src
      └── 📁 app
           ├── 📁 components
           ├── 📁 services
           └── 📁 pages
📌 Points forts
- Interface intuitive
- Processus simplifié pour les étudiants
- Outils de suivi pour les enseignants
- Notifications automatisées
- Architecture modulaire
✅ Fonctionnalités à venir
- Authentification OAuth2
- Génération automatique de rapports PDF
- Intégration d’un calendrier pour les soutenances
- Statistiques de performance
📄 Licence
Projet développé à des fins académiques – tous droits réservés.
