# git cheat sheet: the syntax from the reading, grouped by job
git version                                  # show the installed Git version
git config --global user.name "YourUsername" # set my name once
git config --global user.email "you@email"   # set my email once
gh auth login                                # log in to GitHub from the terminal

git add filename.txt                         # stage one file
git add .                                    # stage new and changed files here
git add -A                                   # stage everything in the repository
git diff                                     # working directory against last commit
git diff HEAD~1 HEAD                         # last commit against the one before
git diff branch-1 branch-2                   # compare two branches

git branch                                   # list branches
git branch new-branch                        # create a branch
git branch -d branch-name                    # delete a branch (after merging)
git checkout main                            # switch to main
git switch branch-name                       # switch to a branch

git clone <repository URL>                   # copy a remote repo to my machine
git pull origin main                         # fetch and merge from origin
git push origin branch-name                  # upload my branch to origin
git remote                                   # list remote names
git remote -v                                # list remotes with their URLs
git remote add origin <URL>                  # add a remote called origin
git remote rename origin upstream            # rename a remote
git remote rm origin                         # remove a remote

git revert HEAD                              # undo the last commit with a new commit
git restore filename                         # discard changes in a file
git restore --staged filename                # unstage a file
git restore --source <commit> filename       # restore a file from a commit
git reset                                    # unstage everything
git reset --hard HEAD                        # DANGER: wipes uncommitted changes

git format-patch HEAD~3                      # make patches for the last 3 commits
git request-pull origin/main <branch>        # summarise pending changes for a maintainer
git send-email *.patch                       # email the patches
git am patchfile.patch                       # apply a patch
git daemon --base-path=/path/to/repositories # serve repos over git://
git instaweb --httpd=webrick                 # browse a repo in a quick web server
git config --global rerere.enabled true      # let rerere remember conflict fixes
git rerere                                   # reuse a recorded conflict fix