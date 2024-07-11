create extension if not exists "pgcrypto";

create table epic (
  id UUID default gen_random_uuid() primary key,
  title text null,
  "desc" text null,
  status boolean not null,
  created_at timestamp null
);
