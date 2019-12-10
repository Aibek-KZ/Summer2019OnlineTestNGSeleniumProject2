package tests.day5;

public class NoteHowToCreateProject {
    /*
  Create a project with:
Artifact id: BasicNavigationTests
group id: com.cbt
then, go to src --> test --> java
right click on java, and create a package: com.cbt.utilities
then, right click on cbt and create a package with name:
com.cbt.tests.
. (dot) works as a delimiter. When you put . in between words,
 it creates 2 packages.
 Then Enable auto-import .
Add dependencies and properties:
    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>
    <dependencies>
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>3.7.1</version>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
    </dependencies>
They will add selenium into our project and webdriver manager.
Plus, it will tell Maven to use java 8. Because, by default
maven is using java 5.
Create local git repo for new project.
git init
Initialized empty Git repository in /Users/studio2/IdeaProjects/BasicNavigationTests/.git/
create .gitignore file
Files that you never want to commit to the github.
add to that file following:
target
.idea
click save..
Then
git add .
git commit -m "first commit"
git remote add origin <YOUR REPO URL>
git push -u origin master

     */
}
