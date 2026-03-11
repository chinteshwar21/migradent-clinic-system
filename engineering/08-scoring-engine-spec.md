# Scoring Engine Specification

## Purpose
Define the scoring engine that computes candidate suitability scores based on configurable rules and weights.

## Requirements
- Configurable scoring templates with rule definitions and weights.
- Deterministic computation given input raw scores and template.
- Support for derived scores (e.g. weighted average, thresholds).
- Auditable results and ability to re-run with historical templates.

## Input
- `raw_scores` (JSON) — keyed values from reviewer inputs, e.g. `{ "clinical_skill": 4, "experience": 3 }`
- `template` (JSON) — defines weight and transformation per field, e.g.:
  ```json
  {
    "fields": {
      "clinical_skill": { "weight": 0.6 },
      "experience": { "weight": 0.4 }
    }
  }
  ```

## Output
- `total_score` (numeric): weighted sum normalized to scale (e.g., 0-100)
- `breakdown` (JSON): per-field weighted contributions

## Rule Types
- Weighting: multiply field by weight.
- Threshold rules: add or flag if field < X.
- Derived fields: computed from multiple inputs.
- Conditional rules: apply weight only if condition holds.

## Versioning & Audit
- Each template stored with `version` and `created_at`.
- Scores store `template_id` and `template_version` to allow re-calculation.
- Log events for manual overrides with `override_reason` and actor.

## Implementation Notes
- Implement scoring engine as a small, well-tested library that can be invoked by the API or run in background workers.
- Use JSON Schema to validate templates before activation.
- Provide a dry-run API endpoint for previewing scores.

## Performance
- Calculation is lightweight per candidate; support batch runs for imports.

---
Generated: 08-scoring-engine-spec.md
