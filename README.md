# New Migradent (Monorepo)

This repository contains a lightweight monorepo scaffold for the Migradent MVP. It includes:

- `apps/api-server` — minimal Node.js Express API
- `apps/web-client` — minimal static web client (calls the API)
- `packages/scoring-engine` — small scoring library used by the API
- `docker-compose.yml` — local Postgres and Redis for development
- Documentation files (product & architecture) already present in repo root

Quick start (Windows PowerShell):

```powershell
# 1) Install dependencies (at repo root)
npm install

# 2) Start backend API (development)
npm run dev:api

# 3) Serve web-client dist (for static demo)
npm run dev:web

# 4) Or start Docker dependencies
npm run docker:up
```

Notes:
- This is a scaffold. Run `npm install` in the repo root to fetch workspace tooling where appropriate.
- See `apps/api-server/README.md` and `apps/web-client/README.md` for per-app instructions.
