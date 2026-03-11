# Monorepo Structure

This project uses a lightweight monorepo to host frontend, backend, scoring engine, and infra modules.

## Proposed Layout
```
/ (repo root)
  /apps
    /web-client        # React app
    /api-server        # Backend REST API
    /scoring-engine    # Service or library for scoring logic
  /packages
    /ui-components     # shared UI components
    /db-migrations     # migration scripts
    /shared-types      # shared TypeScript types or API schemas
  /infra              # IaC (azd/bicep/terraform)
  /docs               # product and architecture docs
  package.json        # workspace scripts
  README.md
```

## Tooling
- Use `pnpm` or `npm` workspaces for JS/TS packages.
- Each app has own Dockerfile for containerization.
- Shared types published locally via workspace package.

## CI/CD
- Single pipeline with per-path triggers to run affected-project tests and build steps.
- Deployment jobs per environment (staging, prod).

## Development Scripts (examples)
- `pnpm --filter api-server dev`
- `pnpm --filter web-client dev`
- `pnpm build` (build all)

---
Generated: 07-monorepo-structure.md
