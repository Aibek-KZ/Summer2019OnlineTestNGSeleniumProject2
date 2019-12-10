package tests.day12;

public class gitHubPush {
    /*
    git init - initialize local repository for project
git add . - prepare files for commit
git commit -m "commit message" - commit code (take a snapshot)
git push - send updated project to github

    GIT - is  a version control tool
    what does it mean version control?
In the simple words, git is a technology that helps you to track changes in your project/code.
git also help to collaborate. Main version of  the code resides in the remote repository. In our case - github.
Then anyone who wants to collaborate can get a copy of that project.
git tracks changes and shows what and when was changed by whom.
git vs github?
git - is a VersionControlSystem tool
github - is a storage for git projects. Github is like a smart google driver, that targets git projects.
github it's not only one available solution.
I used BitBucket, it also works with git. BitBucket from same developers as a Jira.
How we can see history of changes in git project?
 Check commits
Every commit it's like a snapshot, you want to do a snapshot to capture changes.
class Person{
    int age;
}
commit1 "First commit"
class Person{
    int age;
    String name;
}
commit2: "Added string variable name"
class Person{
    int age;
    String name;
    String address;
}
commit3: "Added address variable"
Why do we keep project on github?
Because it's not secured to have only one place for saving.
It's more secured to have a back up
Also, github will help to collaborate multiple people on the same project.
#####################Create new project
File -- new --> project
Select Maven project
Click next
group id: com.gitpractice
artifact id: Summer2019GitPractice
Select "Enable auto-import"
src --> main --> java create package "java_code"
Then create a class person
Step 1. git init
Initialized empty Git repository in /Users/CybertekStudios1/IdeaProjects/Summer2019GitPractice/.git/
Step 2. Right click on the project and create .gitignore file.
This file will contain list of files/folders that shouldn't be committed. Like target, .idea
Open that file and add:
target
.idea


 git is a version control tool
    it keeps track of changes that were made
    git remember who did changes, when and what kind of changes
    it helps to collaborate, so multiple developers can easily work together on the same project
    Also, git is a distributed version control system (DVCS).
    Main version of the project will be in the cloud (for example github)
github it's a google driver for git projects/repositories
    for project we create a git repository.
    we have local repository (on your computer)
    and we have remote repository (on github)
    git know about changes in your project
    github works as cloud storage for your project
    The process of getting a copy of project call cloning
    git clone - stands for getting a copy of project from remote repository (github)
PLease comeback at 3:15
git init - initialize local repository for project
git add . - prepare files for commit
git commit -m "commit message" - commit code (take a snapshot)
git push - send updated project to github
Don't forget to connect local repo with remote!
First create repo on github and then github will show instruction.
Invite only for Elvira, sorry
//command that will connect local and remote repo
//CybertekSchool it's my github username, instead you should see yours
git remote add origin https://github.com/CybertekSchool/Summer2019GitPractice.git
git remote set-url origin <YOUR GITHUB LINK>
last command, it runs only once, then just git push:
 git push -u origin master

     */
}
