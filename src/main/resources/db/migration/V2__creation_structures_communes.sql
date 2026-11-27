CREATE OR REPLACE FUNCTION maj_date_modification()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
BEGIN
    NEW.date_modification = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$;
