# run this inside your practice folder, not inside IMI Projects
cd ~/git-lab

# copy a repo to this computer (swap in a real URL)
git clone https://github.com/AnitaDaniel77/paynest.git
cd paynest

# see which remotes this clone knows about
git remote -v

# add the original project as upstream (Hilbert's repo)
git remote add upstream https://github.com/hilbertdev/paynest.git

# confirm origin and upstream both show up
git remote -v

# download upstream changes without merging them
git fetch upstream

# bring those changes into your main branch
git merge upstream/main

# send the updated main to your fork on GitHub
git push origin main

# shortcut: fetch and merge in one step
git pull upstream main