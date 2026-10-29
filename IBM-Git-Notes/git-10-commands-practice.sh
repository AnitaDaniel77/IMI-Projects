# practice run of the video's commands, outside IMI Projects
cd ~/OneDrive
mkdir MyRepository          # make the project folder
cd MyRepository             # go inside it
git init                    # start a repository here
echo "<h1>Hello</h1>" > index.html   # create the first file
git add index.html          # stage the file
git commit -m "Create a new HTML file"   # save the snapshot
git log                     # confirm the commit is recorded
git branch code_list        # create the experiment branch
git checkout code_list      # move onto it
echo "<p>Code list</p>" >> index.html    # change the file on the branch
git add index.html          # stage the change
git commit -m "Update index.html file in branch"   # save it on the branch
git status                  # check the working directory is clean
git checkout main           # back to main (use master if that's your default)
git merge code_list         # bring the branch changes into main
git log                     # both commits should show now