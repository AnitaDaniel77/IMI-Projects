# the demo's commands, in order (run inside a cloned repo, not IMI Projects)
git clone https://github.com/AnitaDaniel77/testrepo.git   # copy the repo here
cd testrepo                                  # go inside the copy
git branch                                   # list branches
git branch PATCH-1-ADDING-HEADERS            # create the new branch
git checkout PATCH-1-ADDING-HEADERS          # move onto it
echo "<h1>Welcome</h1>" > index.html         # make a change on the branch
git status                                   # index.html shows as untracked or modified
git add index.html                           # stage the change
git commit -m "Added header"                 # save it on the branch
git checkout main                            # back to main
git merge PATCH-1-ADDING-HEADERS             # bring the change into main
git push -u origin main                      # send main to GitHub
git status                                   # confirm everything is up to date