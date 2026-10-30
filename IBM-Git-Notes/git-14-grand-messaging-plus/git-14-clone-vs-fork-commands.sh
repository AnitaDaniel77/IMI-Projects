# run this in your practice folder, not in IMI Projects
cd ~/git-lab

# make a small practice repo
mkdir grand-messaging && cd grand-messaging
git init

# add the original Java file (copy GrandMessagingPlus.java in first)
git add .
git commit -m "Original Grand Messaging"

# branch for the new Plus feature
git branch feature-scheduled
git checkout feature-scheduled

# after editing the file, save the change
git add GrandMessagingPlus.java
git commit -m "Add scheduled sending"

# reviewer view: compare main with the feature branch
git diff main feature-scheduled

# merge the feature into main
git checkout main
git merge feature-scheduled

# with a real remote you would also run:
# git push -u origin feature-scheduled   (first push sets the upstream branch)
# git fetch                               (reviewer gets the latest)