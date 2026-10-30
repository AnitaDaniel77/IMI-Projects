# --- Final Project Part 2: the commands I used ---

# Check my fork points at the IBM original
curl -s https://api.github.com/repos/AnitaDaniel77/mcino-Introduction-to-Git-and-GitHub | jq -r '.parent.clone_url'

# Clone my fork and make the fix branch
git clone https://github.com/AnitaDaniel77/mcino-Introduction-to-Git-and-GitHub.git
cd mcino-Introduction-to-Git-and-GitHub
git checkout -b bug-fix-typo

# Find the footer line, change the year, and check the diff
grep -n "XYZ" README.md
sed -i '16s/2022 XYZ/2023 XYZ/' README.md
git diff

# Commit and push the branch (token goes in the password prompt)
git add README.md
git commit -m "Fix footer year from 2022 to 2023 in README"
git push -u origin bug-fix-typo

# Merge into main (fast-forward)
git checkout main
git merge bug-fix-typo

# Revert on a new branch, then push it
git checkout -b bug-fix-revert
git log --oneline -3
git revert 6edd723 --no-edit
git push -u origin bug-fix-revert

# Verify the pull request and list branch status
curl -s https://api.github.com/repos/ibm-developer-skills-network/mcino-Introduction-to-Git-and-GitHub/pulls/13184 | jq -r '.head.repo.clone_url'
git branch -vv