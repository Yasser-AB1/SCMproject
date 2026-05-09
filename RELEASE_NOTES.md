# Release Notes — Student Grade Calculator

## v1.1 — 2026-05-11

### New Features
- Weighted average calculation: each subject now accepts a percentage weight
- Refined letter grading scale with +/- distinctions (A, A-, B+, B, B-, C, D, F)
- Export results to a .txt file named after the student

### Bug Fixes
- Resolved merge conflict in `getLetterGrade()` between v1.0 and v1.1 grading scales

---

## v1.0 — 2026-05-09

### New Features
- Input student name and scores for multiple subjects
- Calculates simple average across all subjects
- Converts average to a letter grade (A, B, C, D, F)
- Displays pass/fail status (passing threshold: 60)

### Notes
- Initial release. All input/output via command line.